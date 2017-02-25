package com.leostones.applicationmarket.ui.fragment;

import android.view.View;

import com.leostones.applicationmarket.domain.AppInfo;
import com.leostones.applicationmarket.http.protocol.AppProtocol;
import com.leostones.applicationmarket.ui.adapter.MyBaseAdapter;
import com.leostones.applicationmarket.ui.holder.AppHolder;
import com.leostones.applicationmarket.ui.holder.BaseHolder;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
import com.leostones.applicationmarket.ui.view.MyListView;
import com.leostones.applicationmarket.utils.UIUtils;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/14  18:05
 * 邮箱：
 * 说明：应用
 */
public class AppFragment extends BaseFragment{

    private ArrayList<AppInfo> data;
    @Override
    public View onCreateSuccessView() {
        // TextView view = new TextView(UIUtils.getContext());
        // view.setText(getClass().getSimpleName());
        MyListView view = new MyListView(UIUtils.getContext());

        view.setAdapter(new AppAdapter(data));
        return view;
    }

    @Override
    public ResultState onLoad() {
        AppProtocol protocal = new AppProtocol();
        data = protocal.getData(0);
        return check(data); //检测数据是否合法
    }
    class AppAdapter extends MyBaseAdapter<AppInfo>{

        public AppAdapter (ArrayList<AppInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<AppInfo> getHolder(int position) {
            return new AppHolder() ;
        }

        @Override
        public ArrayList<AppInfo> onLoadMore() {
            AppProtocol protocal = new AppProtocol();
            ArrayList<AppInfo> moreData =  protocal.getData(getListSize());
            return moreData;
        }
    }
}
