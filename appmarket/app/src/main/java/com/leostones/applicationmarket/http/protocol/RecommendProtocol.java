package com.leostones.applicationmarket.http.protocol;

import org.json.JSONArray;

import java.util.ArrayList;


/**
 * 作者：LeoStones
 * 时间：2016/11/23  19:01
 * 邮箱：
 * 说明：${TODO}$
 */
public class RecommendProtocol extends BaseProtocol<ArrayList<String>>{
    private ArrayList<String> mRecommendList;

    @Override
    public String getKey() {
        return "recommend";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<String> parseData(String result) {
        try {
            JSONArray ja = new JSONArray(result);
            mRecommendList= new ArrayList<String>();

            for (int i = 0; i < ja.length(); i++) {
                String str = ja.getString(i);
                mRecommendList.add(str);
            }
            return  mRecommendList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
