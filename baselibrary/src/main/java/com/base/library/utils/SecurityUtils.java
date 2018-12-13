package com.base.library.utils;

import com.base.library.app.BaseApp;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Created by Ben on 2015/1/12.
 */
public class SecurityUtils {

    private static final Object PARTNER_KEY = "219F223CB59B183D3A80708E8553AFA71b49";
    private static final Object PARTNER_KEY_Store = "db426a9829e4b49a0dcac7b4162da6b6";

    public static LinkedList<KeyValue> sortParam(Map<String, Object> params) {
        LinkedList<KeyValue> pairs = new LinkedList<KeyValue>();
        ArrayList<String> temp = new ArrayList<String>();
        for (String key : params.keySet()) {
            temp.add(key);
        }
        temp.trimToSize();
        Collections.sort(temp);
        Gson gson = new Gson();
        for (String string : temp) {
            Object valueObj = params.get(string);
            String value = "";
            if (valueObj != null) {
                if (valueObj instanceof Integer || valueObj instanceof String || valueObj instanceof Double || valueObj instanceof Float
                        || valueObj instanceof Long || valueObj instanceof Boolean || valueObj instanceof Byte || valueObj instanceof Character) {
                    value = valueObj.toString();
                } else {
                    value = gson.toJson(valueObj);
                }
            }
            pairs.add(new KeyValue(string, value));
        }
        return pairs;
    }

    public static String signParams(Map<String, Object> params, int keyType) {
        LinkedList<KeyValue> paramList = sortParam(params);
        StringBuilder sb = new StringBuilder();

        for (KeyValue pair : paramList) {
            sb.append(pair.getKey()).append("=").append(pair.getValue()).append("&");
        }

        sb.append("key=").append(keyType == 0 ? PARTNER_KEY : PARTNER_KEY_Store);

        String sign = getMessageDigest(sb.toString().getBytes(Charset.defaultCharset()));
        return sign;
    }

    public final static String getMessageDigest(byte[] buffer) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            byte[] md = mdTemp.digest(buffer);
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return "";
        }
    }

    public static String generSign(String parkId, String plateNum, String changeId) {
        Map<String, Object> tempMap = new HashMap<String, Object>();
        tempMap.put("parkId", parkId);
        tempMap.put("plateNum", plateNum);
        tempMap.put("changeId", changeId);
        JSONObject jsonObject = new JSONObject(tempMap);
        String result = "";
        try {
            result = AESUtil.encrypt(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getSign() {
        Map<String, Object> tempMap = new HashMap<String, Object>();
        tempMap.put("v", PackageUtils.getVersionName(BaseApp.getInstance()));
        tempMap.put("device", "android");
        tempMap.put("ttid", "1");
        return signParams(tempMap,1);
    }

    public static class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
