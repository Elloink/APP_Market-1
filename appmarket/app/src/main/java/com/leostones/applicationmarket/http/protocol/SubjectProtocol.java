package com.leostones.applicationmarket.http.protocol;

import com.leostones.applicationmarket.domain.SubjectInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/22  10:16
 * 邮箱：
 * 说明：${TODO}$
 */
public class SubjectProtocol extends BaseProtocol<ArrayList<SubjectInfo>> {

    @Override
    public String getKey() {
        return "subject";
    }

    @Override
    public String getParams() {
        return "";
    }

    @Override
    public ArrayList<SubjectInfo> parseData(String result) {
        try {
            JSONArray ja = new JSONArray(result);
            ArrayList<SubjectInfo> mList = new ArrayList<SubjectInfo>();

            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);

                SubjectInfo info = new SubjectInfo();
                info.des = jo.getString("des");
                info.url = jo.getString("url");

                mList.add(info);
            }
            return mList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
