package com.base.library.net;

import com.base.library.utils.SecurityUtils;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/**
 * Created by ghg on 2016/03/16.
 */
public class CustomRequestConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final Type type;
    private static boolean isUploadImg = false;         //是否上传图片的请求

    CustomRequestConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        Buffer buffer = null;
        Writer writer = null;
        try {
            buffer= new Buffer();
            writer=new OutputStreamWriter(buffer.outputStream(), UTF_8);
            HashMap<String, Object> paramMap = sign(value, 1);
            gson.toJson(paramMap, HashMap.class, writer);
            writer.flush();
        } catch (Exception e) {
            throw new AssertionError(e); // Writing to Buffer does no I/O.
        } finally {
            if(buffer!=null){
                try {
                    buffer.close();
                }catch (Throwable t){

                }
            }
            writer.close();

        }
        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }

    public static HashMap<String, Object> sign(Object obj, int keyType) throws IllegalArgumentException,
            IllegalAccessException {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Class clazz = obj.getClass();
        List<Class> clazzs = new ArrayList<Class>();
        do {
            clazzs.add(clazz);
            clazz = clazz.getSuperclass();
        } while (!clazz.equals(Object.class));

        isUploadImg = false;

        for (Class iClazz : clazzs) {
            Field[] fields = iClazz.getDeclaredFields();
            for (Field field : fields) {
                Object objVal = null;
                field.setAccessible(true);
                if (field.getName().equals("SignKeyType")) {      //wp.nine 通过该字段来修改签名的KEY值
                    keyType = (int) field.get(obj);
                } else {
                    objVal = field.get(obj);
                    if (objVal != null)//如果为null值 则不计入 md5摘要 ,因为 http传输层 不会把null值送出去 modified by janyo at 2015-5-7
                        hashMap.put(field.getName(), objVal);
                }
                if ((field.getName().equals("pictureByteArr"))) {
                    isUploadImg = true;
                }
            }
        }
        if (!isUploadImg) {     //非图片接口才需要签名
            String sign = SecurityUtils.signParams(hashMap, keyType);
            hashMap.put("sign", sign);
        }

        return hashMap;
    }
}