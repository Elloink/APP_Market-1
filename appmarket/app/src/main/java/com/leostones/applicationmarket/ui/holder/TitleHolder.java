6package com.leostones.applicationmarket.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.leostones.applicationmarket.R;
import com.leostones.applicationmarket.domain.CategoryInfo;
import com.leostones.applicationmarket.utils.UIUtils;

/**
 * 作者：LeoStones
 * 时间：2016/11/26  4:27
 * 邮箱：
 * 说明：${TODO}$
 */
public class TitleHolder extends BaseHolder<CategoryInfo> {
    private TextView tvTitle;

    @Override
    public View initView() {
        View view = View.inflate(UIUtils.getContext(),
                R.layout.list_item_title, null);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        return view;
    }

    @Override
    public void refreshView(CategoryInfo data) {
        tvTitle.setText(data.title);
    }
}
