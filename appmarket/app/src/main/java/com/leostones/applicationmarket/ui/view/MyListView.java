package com.leostones.applicationmarket.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 作者：LeoStones
 * 时间：2016/11/22  4:48
 * 邮箱：
 * 说明：${TODO}$
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
        initview();
    }


    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview() {
        this.setSelector(new ColorDrawable());//设置状态选择器为全透明
        this.setDivider(null);//去掉分割线
        this.setCacheColorHint(Color.TRANSPARENT);//有时候滑动listview背景会便会黑色，此方法将背景变为全透明
    }

}
