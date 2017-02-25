package com.leostones.applicationmarket.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * 作者：LeoStones
 * 时间：2016/11/6  17:32
 * 邮箱：
 * 说明：自定义Application，进行全局初始化
 */
public class ApplicationMarket extends Application{
    private static Context sContext;
    private static Handler sHandler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        sHandler = new Handler();
        mainThreadId = android.os.Process.myTid();
    }
    public static Context getContext(){
        return sContext;
    }
    public static Handler getHandler() {
        return sHandler;
    }
    public static int getMainThreadId(){
        return mainThreadId;
    }
}
