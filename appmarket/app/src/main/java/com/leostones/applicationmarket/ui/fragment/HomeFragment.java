package com.leostones.applicationmarket.ui.fragment;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.leostones.applicationmarket.domain.AppInfo;
import com.leostones.applicationmarket.http.protocol.HomeProtocol;
import com.leostones.applicationmarket.ui.activity.HomeDetailActivity;
import com.leostones.applicationmarket.ui.adapter.MyBaseAdapter;
import com.leostones.applicationmarket.ui.holder.BaseHolder;
import com.leostones.applicationmarket.ui.holder.HomeHeaderHolder;
import com.leostones.applicationmarket.ui.holder.HomeHolder;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
import com.leostones.applicationmarket.ui.view.MyListView;
import com.leostones.applicationmarket.utils.UIUtils;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/4  18:05
 * 邮箱：
 * 说明：首页
 */
public class HomeFragment extends BaseFragment {

    // private ArrayList<String> data;
    private ArrayList<AppInfo> data = null;
    private ArrayList<String> mPicList;

    // 如果加载数据成功, 就回调此方法, 在主线程运行
    @Override
    public View onCreateSuccessView() {
        // TextView view = new TextView(UIUtils.getContext());
        // view.setText(getClass().getSimpleName());
        MyListView view = new MyListView(UIUtils.getContext());

        // 添加头布局
        HomeHeaderHolder header = new HomeHeaderHolder();
        view.addHeaderView(header.getRootView());//先添加头布局，再setAdapter

        view.setAdapter(new HomeAdapter(data));
        if (mPicList != null){
            //设置轮播条数据
            header.setData(mPicList);
        }

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                AppInfo appInfo = data.get(position - 1);// 去掉头布局

                if (appInfo != null) {
                    Intent intent = new Intent(UIUtils.getContext(),
                            HomeDetailActivity.class);
                    intent.putExtra("packageName", appInfo.packageName);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    // 运行在子线程,可以直接执行耗时网络操作
    @Override
    public ResultState onLoad() {
        // 请求网络, HttpClient, HttpUrlConnection, XUtils
        // data = new ArrayList<String>();
        // for (int i = 0; i < 20; i++) {
        // data.add("测试数据:" + i);
        // }
        HomeProtocol protocol = new HomeProtocol();
        data = protocol.getData(0);// 加载第一页数据
        mPicList = protocol.getPicList();
        return check(data);// 校验数据并返回
    }

    class HomeAdapter extends MyBaseAdapter<AppInfo> {

        public HomeAdapter(ArrayList<AppInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<AppInfo> getHolder(int position) {
            return new HomeHolder();
        }

        // 此方法在子线程调用
        @Override
        public ArrayList<AppInfo> onLoadMore() {
            HomeProtocol protocol = new HomeProtocol();
            // 20, 40, 60....
            // 下一页数据的位置 等于 当前集合大小
            ArrayList<AppInfo> moreData = protocol.getData(getListSize());
            SystemClock.sleep(2000);

            return moreData;
        }

    }

    static class ViewHolder {
        public TextView tvContent;
    }

}
