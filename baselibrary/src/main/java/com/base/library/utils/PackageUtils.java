package com.base.library.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;

/**
 * Created by yg on 2018/12/12.
 */

public class PackageUtils {
    private static Toast mToast;
    private static boolean isShowingToast = false;
    private static String mLastToastMsg = null;
    private static final int WHAT_TOAST_RELEASE = 1;
    private static Handler sHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case WHAT_TOAST_RELEASE:
                    isShowingToast = false;
                    break;
                default:
                    break;
            }

        }
    };

    public static void showMsg(Context context, int resId) {
        showMsg(context, context.getString(resId));
    }

    public static void showMsg(Context context, CharSequence msg) {
        if (msg == null) {
            return;
        }
        String result = msg.toString();
        if (!isShowingToast || mLastToastMsg == null || !mLastToastMsg.equals(result)) {//若是不一致的信息,则必须显示 2016.5.6 by wp.nine
            isShowingToast = true;
            mLastToastMsg = result;
            mToast = Toast.makeText(context, result, Toast.LENGTH_LONG);
           /* if (null == mToast) {
                mToast = Toast.makeText(context, result, Toast.LENGTH_LONG);
            } else {
                mToast.setText(msg);
            }*/
            mToast.show();
            sHandler.removeMessages(WHAT_TOAST_RELEASE);
            sHandler.sendEmptyMessageDelayed(WHAT_TOAST_RELEASE, 1500);
        }

    }

    public static String getVersionName(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "V1.0.0";
        }
    }

    public static int getVersionCode(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    public static String convertObjToJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * 判断传入的服务名对应的服务是否在运行
     *
     * @param context
     * @param serviceName
     * @return
     */
    public static boolean isRunningService(Context context, String serviceName) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        boolean hasService = false;
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceName.equals(service.service.getClassName())) {
                hasService = true;
                break;
            }
        }
        return hasService;
    }

    //删除文件夹和文件夹里面的文件
    public static void deleteDir( String pPath) {
        File dir = new File(pPath);
        deleteDirWihtFile( dir);
    }

    //删除文件夹和文件夹里面的文件
    public static void deleteDir( File pPath) {
        deleteDirWihtFile( pPath);
    }

    public static void deleteDirWihtFile( File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        Log.e("GHG dir", dir.getAbsolutePath());
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDirWihtFile( file); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }

    public static void delFile(File file) {
        if (file == null) {
            return;
        }
        Log.e("GHG file", file.getAbsolutePath());
        if (file.isFile()) {
            file.delete();
        }
    }
}
