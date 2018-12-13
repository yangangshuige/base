package com.base.library.net;

import com.base.library.app.BaseApp;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiManager
 * Created by woong on 18/4/23.
 */
public class ApiManager {
    private HashMap<Class, Retrofit> mRetrofitServiceHashMap = new HashMap<>();

    private Retrofit mApiRetrofit;
    private ConcurrentHashMap<Class, Object> cachedApis = new ConcurrentHashMap<>();
    private PersistentCookieJar cookieJar;
    private static ApiManager apiManager;

    public static ApiManager getInstence() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public ApiManager() {
//        cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApp.getInstance()));
        // init okhttp 3 logger
//        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
//        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // init cache
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(45, TimeUnit.SECONDS)
                .writeTimeout(55, TimeUnit.SECONDS)
                .addInterceptor(new CustomInterceptor())
//                .addInterceptor(RetrofitConfig.sQueryParameterInterceptor)
                .addInterceptor(RetrofitConfig.sLoggingInterceptor)
//                .cookieJar(cookieJar)
                .build();

        mApiRetrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(client)
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(RetrofitConfig.converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mRetrofitServiceHashMap.put(TestService.class, mApiRetrofit);
    }

    public <T> void addService(Class<T> clz) {
        mRetrofitServiceHashMap.put(clz, mApiRetrofit);
    }

    public <T> T getService(Class<T> clz) {
        Object obj = cachedApis.get(clz);
        if (obj != null) {
            return (T) obj;
        } else {
            Retrofit retrofit = mRetrofitServiceHashMap.get(clz);
            if (retrofit != null) {
                T service = retrofit.create(clz);
                cachedApis.put(clz, service);
                return service;
            } else {
                return null;
            }
        }
    }

}
