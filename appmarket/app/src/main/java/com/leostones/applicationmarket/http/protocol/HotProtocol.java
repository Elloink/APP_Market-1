package com.leostones.applicationmarket.http.protocol;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/24  13:18
 * 邮箱：
 * 说明：${TODO}$
 */
public class HotProtocol extends BaseProtocol<ArrayList<String>> {
    private ArrayList<String> mHotList;

    @Override
    public String getKey() {
        return "hot";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<String> parseData(String result) {
        try {
            JSONArray ja = new JSONArray(result);
            mHotList= new ArrayList<String>();

            for (int i = 0; i < ja.length(); i++) {
                String str = ja.getString(i);
                mHotList.add(str);
            }
            return  mHotList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
