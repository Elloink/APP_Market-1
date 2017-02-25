package com.leostones.applicationmarket.ui.fragment;

import android.view.View;

import com.leostones.applicationmarket.domain.CategoryInfo;
import com.leostones.applicationmarket.http.protocol.CategoryProtocol;
import com.leostones.applicationmarket.ui.adapter.MyBaseAdapter;
import com.leostones.applicationmarket.ui.holder.BaseHolder;
import com.leostones.applicationmarket.ui.holder.CategoryHolder;
import com.leostones.applicationmarket.ui.holder.TitleHolder;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
import com.leostones.applicationmarket.ui.view.MyListView;
import com.leostones.applicationmarket.utils.UIUtils;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/11/14  18:05
 * 邮箱：
 * 说明：分类
 */
public class CategoryFragment extends BaseFragment{
    private ArrayList<CategoryInfo> data;
    @Override
    public View onCreateSuccessView() {
        MyListView myListView = new MyListView(UIUtils.getContext());
        myListView.setAdapter(new CategoryAdapter(data));
        return myListView;
    }

    @Override
    public ResultState onLoad() {
        CategoryProtocol protocol = new CategoryProtocol();
        data = protocol.getData(0);
        return check(data);
    }

    class CategoryAdapter extends MyBaseAdapter<CategoryInfo> {
        public CategoryAdapter(ArrayList<CategoryInfo> data) {
            super(data);
        }

        // 根据当前位置,返回相应的Holder对象
        @Override
        public BaseHolder<CategoryInfo> getHolder(int position) {
            CategoryInfo info = getItem(position);
            if (info.isTitle) {
                return new TitleHolder();// 标题栏holder
            }
            return new CategoryHolder();// 普通类型holer
        }

        @Override
        public ArrayList<CategoryInfo> onLoadMore() {
            return null;
        }

        @Override
        public boolean hasMore() {
            return false;// 没有更多数据, 无需加载下一页
        }

        @Override
        public int getViewTypeCount() {
            return super.getViewTypeCount() + 1;// 在原来基础上,新增标题栏类型
        }

        // 根据位置判断当前item的类型
        @Override
        public int getInnerType(int position) {
            CategoryInfo info = getItem(position);
            if (info.isTitle) {// 标题栏类型
                return super.getInnerType(position) + 1;
            } else {// 普通类型
                return super.getInnerType(position);
            }
        }
    }

}
