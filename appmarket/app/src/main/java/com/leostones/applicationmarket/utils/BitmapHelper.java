package com.leostones.applicationmarket.utils;

import com.lidroid.xutils.BitmapUtils;

/**
 * 作者：LeoStones
 * 时间：2016/11/22  4:12
 * 邮箱：
 * 获取BitmapUtils对象, 保证多个模块共用一个BitmapUtils对象,避免内存溢出
 * */
public class BitmapHelper {
    //单例 懒汉
    private static BitmapUtils mBitmapUtils = null;
    public static BitmapUtils getBitmapUtils() {
        if (mBitmapUtils == null) {
            synchronized (BitmapHelper.class){
                if (mBitmapUtils == null){
                    mBitmapUtils = new BitmapUtils(UIUtils.getContext());
                }
            }
        }
        return mBitmapUtils;

    }
}
