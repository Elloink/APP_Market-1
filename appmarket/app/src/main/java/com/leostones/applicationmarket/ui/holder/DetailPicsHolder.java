package com.leostones.applicationmarket.ui.holder;

import android.view.View;
import android.widget.ImageView;

import com.leostones.applicationmarket.R;
import com.leostones.applicationmarket.domain.AppInfo;
import com.leostones.applicationmarket.http.HttpHelper;
import com.leostones.applicationmarket.utils.BitmapHelper;
import com.leostones.applicationmarket.utils.UIUtils;
import com.lidroid.xutils.BitmapUtils;

import java.util.ArrayList;

/**
 * 作者：LeoStones
 * 时间：2016/12/12  20:14
 * 邮箱：
 * 说明：${TODO}$
 */
public class DetailPicsHolder extends BaseHolder<AppInfo> {
    private ImageView[] ivPics;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.layout_detail_picinfo);

        ivPics = new ImageView[5];
        ivPics[0] = (ImageView) view.findViewById(R.id.iv_pic1);
        ivPics[1] = (ImageView) view.findViewById(R.id.iv_pic2);
        ivPics[2] = (ImageView) view.findViewById(R.id.iv_pic3);
        ivPics[3] = (ImageView) view.findViewById(R.id.iv_pic4);
        ivPics[4] = (ImageView) view.findViewById(R.id.iv_pic5);

        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        final ArrayList<String> screen = data.screen;

        for (int i = 0; i < 5; i++) {
            if (i < screen.size()) {
                mBitmapUtils.display(ivPics[i], HttpHelper.URL + "image?name="
                        + screen.get(i));

                //				ivPics[i].setOnClickListener(new OnClickListener() {
                //
                //					@Override
                //					public void onClick(View v) {
                //						//跳转activity, activity展示viewpager
                //						//将集合通过intent传递过去, 当前点击的位置i也可以传过去
                //						Intent intent = new Intent();
                //						intent.putExtra("list", screen);
                //					}
                //				});
            } else {
                ivPics[i].setVisibility(View.GONE);
            }
        }

    }
}
