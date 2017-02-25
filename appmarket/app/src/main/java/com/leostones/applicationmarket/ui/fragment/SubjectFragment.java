package com.leostones.applicationmarket.ui.fragment;

import android.view.View;

import com.leostones.applicationmarket.domain.SubjectInfo;
import com.leostones.applicationmarket.http.protocol.SubjectProtocol;
import com.leostones.applicationmarket.ui.adapter.MyBaseAdapter;
import com.leostones.applicationmarket.ui.holder.BaseHolder;
import com.leostones.applicationmarket.ui.holder.SubjectHolder;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
import com.leostones.applicationmarket.ui.view.MyListView;
import com.leostones.applicationmarket.utils.UIUtils;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/4  18:05
 * 邮箱：
 * 说明：专题
 */
public class SubjectFragment extends BaseFragment{
    private ArrayList<SubjectInfo> data;
    @Override
    public View onCreateSuccessView() {
        MyListView view = new MyListView(UIUtils.getContext());
        view.setAdapter(new SubjectAdapter(data));
        return view;
    }

    @Override
    public ResultState onLoad() {
        SubjectProtocol protocol = new SubjectProtocol();
        data = protocol.getData(0);
        return check(data);
    }
    class SubjectAdapter extends MyBaseAdapter<SubjectInfo> {
        public SubjectAdapter(ArrayList<SubjectInfo> data) {
            super(data);
        }

        @Override
        public BaseHolder<SubjectInfo> getHolder(int position) {
            return new SubjectHolder();
        }

        @Override
        public ArrayList<SubjectInfo> onLoadMore() {

            SubjectProtocol protocol = new SubjectProtocol();
            ArrayList<SubjectInfo> moreData = protocol.getData(getListSize());
            return moreData;
        }
    }

}
