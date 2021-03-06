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
 * 时间：2016/12/12  18:56
 * 邮箱：
 * 说明：${TODO}$
 */
public class DetailAppInfoHolder extends BaseHolder<AppInfo> {
    private ImageView ivIcon;
    private TextView tvName;
    private TextView tvDownloadNum;
    private TextView tvVersion;
    private TextView tvDate;
    private TextView tvSize;
    private RatingBar rbStar;
    private BitmapUtils mBitmapUtils;

    @Override
    public View initView() {
        View view = UIUtils.inflate(R.layout.layout_detail_appinfo);

        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvDownloadNum = (TextView) view.findViewById(R.id.tv_download_num);
        tvVersion = (TextView) view.findViewById(R.id.tv_version);
        tvDate = (TextView) view.findViewById(R.id.tv_date);
        tvSize = (TextView) view.findViewById(R.id.tv_size);
        rbStar = (RatingBar) view.findViewById(R.id.rb_star);

        mBitmapUtils = BitmapHelper.getBitmapUtils();

        return view;
    }

    @Override
    public void refreshView(AppInfo data) {
        mBitmapUtils.display(ivIcon, HttpHelper.URL + "image?name="
                + data.iconUrl);
        tvName.setText(data.name);
        tvDownloadNum.setText("下载量:" + data.downloadNum);
        tvVersion.setText("版本号:" + data.version);
        tvDate.setText(data.date);
        tvSize.setText(Formatter.formatFileSize(UIUtils.getContext(), data.size));
        rbStar.setRating(data.stars);
    }
}
