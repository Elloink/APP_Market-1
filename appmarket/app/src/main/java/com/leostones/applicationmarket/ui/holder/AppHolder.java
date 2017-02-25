package com.leostones.applicationmarket.ui.holder;

import android.text.format.Formatter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.leostones.applicationmarket.R;
import com.leostones.applicationmarket.domain.AppInfo;
import com.leostones.applicationmarket.http.HttpHelper;
import com.leostones.applicationmarket.utils.BitmapHelper;
import com.leostones.applicationmarket.utils.UIUtils;
import com.lidroid.xutils.BitmapUtils;

/**
 * 作者：LeoStones
 * 时间：2016/11/17  19:43
 * 邮箱：
 * 说明：${TODO}$
 */
public class AppHolder extends BaseHolder<AppInfo> {


    private TextView tvName;
    private ImageView ivIcon;
    private TextView tvSize;
    private TextView tvDesc;
    private RatingBar rbStar;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        // 1. 加载布局
        View view = UIUtils.inflate(R.layout.list_item_home);
        // 2. 初始化控件
        tvName = (TextView) view.findViewById(R.id.tv_name);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
        tvSize = (TextView) view.findViewById(R.id.tv_size);
        tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        rbStar = (RatingBar) view.findViewById(R.id.rb_star);

        mBitmapUtils = BitmapHelper.getBitmapUtils();
       return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        tvName.setText(data.name);
        tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(),
                data.size));
        tvDesc.setText(data.des);
        rbStar.setRating((float) data.stars);
        mBitmapUtils.display(ivIcon, HttpHelper.URL + "image?name="
                + data.iconUrl);

    }
}
