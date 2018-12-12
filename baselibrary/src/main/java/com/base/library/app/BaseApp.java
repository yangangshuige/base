package com.base.library.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Environment;
import android.support.multidex.MultiDex;

import org.litepal.LitePal;
import java.io.File;
import cn.bingoogolapple.swipebacklayout.BGASwipeBackManager;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
public class BaseApp extends Application {
    private static BaseApp sMyApp;
    public static final String ROOT_DIR_PATH = "/BaseFramework/cache";
    public static final String LOG_DIR_PATH = ROOT_DIR_PATH + "log";

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        //初始化滑动返回
        BGASwipeBackManager.getInstance().init(this);
        //初始化数据库
        LitePal.initialize(this);
        //异常抓取日志
        exceptionCrash();
        //设置字体不随着系统的字体变大而变大
        unSppuortSystemFont();


    }

    private void exceptionCrash() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + LOG_DIR_PATH;
        File storePath = new File(path);
        storePath.mkdirs();
        Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(
                path, null));
    }

    /***
     * 设置字体不随着系统的字体变大而变大
     */
    public void unSppuortSystemFont() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static BaseApp getInstance() {
        return sMyApp;
    }


}
