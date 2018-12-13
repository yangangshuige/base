package com.base.library.net;


import android.util.Log;

import com.base.library.app.BaseApp;
import com.base.library.utils.NetUtil;
import com.base.library.utils.PackageUtils;
import com.base.library.utils.SecurityUtils;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ghg on 2016/03/05.
 */
public class CustomInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = String.valueOf(request.url());
        Request.Builder builder = request.newBuilder();
        if ("GET".equals(request.method())) {
            if (url.contains("?")) {
                url = url + "&v=" + PackageUtils.getVersionName(BaseApp.getInstance()) + "&device=android&ttid=1";
            } else {
                url = url + "?v=" + PackageUtils.getVersionName(BaseApp.getInstance()) + "&device=android&ttid=1";
            }
            HashMap hashMap = new HashMap();
            String param = url.split("[?]")[1];
            String[] strs = param.split("&");
            for (String str : strs) {
                String[] keyvalue = str.split("=");
                if (2 == keyvalue.length) {
                    hashMap.put(keyvalue[0], URLDecoder.decode(keyvalue[1]));
                } else {
                    hashMap.put(keyvalue[0], null);
                }
            }
            String signUrl = url + "&sign=" + SecurityUtils.signParams(hashMap, 1);
            builder.url(signUrl);
            builder.addHeader("Content-Type", "application/json");
        } else {
            builder.addHeader("Content-Type", "application/json");
        }
        if (url.contains("getParkInfo")) {
            return chain.proceed(builder.build());
        }
        if (!NetUtil.isNetworkAvailable(BaseApp.getInstance())) {  //外网不可连，直接抛异常
            Log.e("GHG", "" + url);
            throw new RuntimeException();
        } else {
            return chain.proceed(builder.build());
        }
    }
}
