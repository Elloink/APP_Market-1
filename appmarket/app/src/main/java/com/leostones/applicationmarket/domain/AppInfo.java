package com.leostones.applicationmarket.domain;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/19  9:29
 * 邮箱：
 * 说明：首页应用信息封装
 */
public class AppInfo {
    public String des;
    public String downloadUrl;
    public String iconUrl;
    public String id;
    public String name;
    public String packageName;
    public long size;
    public float stars;

    //补充字段, 供应用详情页使用
    public String author;
    public String date;
    public String downloadNum;
    public String version;
    public ArrayList<SafeInfo> safe;
    public ArrayList<String> screen;

    //当一个内部类是public static的时候, 和外部类没有区别
    public static class SafeInfo {
        public String safeDes;
        public String safeDesUrl;
        public String safeUrl;
    }
}
