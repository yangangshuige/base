package com.base.library.net;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


/**
 * Created by ghg on 2016/03/16.
 */
public class CustomResponseConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomResponseConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JsonReader jsonReader =null;
        try {
            jsonReader=  gson.newJsonReader(value.charStream());
            return adapter.read(jsonReader);
        } finally {
            if (jsonReader!=null){
                try {
                    jsonReader.close();
                }catch (Throwable t){

                }
            }
            value.close();
        }
    }
}
