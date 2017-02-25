package com.leostones.applicationmarket.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leostones.applicationmarket.R;
import com.leostones.applicationmarket.domain.SubjectInfo;
import com.leostones.applicationmarket.http.HttpHelper;
import com.leostones.applicationmarket.utils.BitmapHelper;
import com.leostones.applicationmarket.utils.UIUtils;
import com.lidroid.xutils.BitmapUtils;

/**
 * 作者：LeoStones
 * 时间：2016/11/22  10:29
 * 邮箱：
 * 说明：专题
 */
public class SubjectHolder extends BaseHolder<SubjectInfo> {

    private ImageView mIvpic;
    private TextView mTvtitle;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.list_item_subject);
        mIvpic = (ImageView) view.findViewById(R.id.iv_pic);
        mTvtitle = (TextView) view.findViewById(R.id.tv_title);

        mBitmapUtils = BitmapHelper.getBitmapUtils();
        return view;
    }


    @Override
    public void refreshView(SubjectInfo data) {
        mTvtitle.setText(data.des);
        mBitmapUtils.display(mIvpic, HttpHelper.URL + "image?name="
                + data.url);
    }
}
