package com.leostones.applicationmarket.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.leostones.applicationmarket.http.protocol.HotProtocol;
import com.leostones.applicationmarket.ui.view.FlowLayout;
import com.leostones.applicationmarket.ui.view.LoadingPage.ResultState;
import com.leostones.applicationmarket.utils.DrawableUtils;
import com.leostones.applicationmarket.utils.UIUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 作者：LeoStones
 * 时间：2016/11/4  18:05
 * 邮箱：
 * 说明：排行
 */
public class HotFragment extends BaseFragment {
    private ArrayList<String> data;

    @Override
    public View onCreateSuccessView() {
        int padding = UIUtils.dip2px(10);
        //支持上下滑动
        ScrollView scrollView = new ScrollView(UIUtils.getContext());
        //设置文字边距
        scrollView.setPadding(padding,padding,padding,padding);
        //初始化自定义控件
        FlowLayout flowLayout =   new FlowLayout(UIUtils.getContext());

        for (int i = 0; i < data.size(); i++) {
            final String wards = data.get(i);
            TextView textView = new TextView(UIUtils.getContext());
            textView.setText(wards);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setPadding(padding,padding,padding,padding);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);

            // 设置随机文字颜色
            Random random = new Random();
            int r = 30 + random.nextInt(210);
            int g = 30 + random.nextInt(210);
            int b = 30 + random.nextInt(210);

            int color = 0xffcecece;// 按下后偏白的背景色

            // 根据默认颜色和按下颜色, 生成圆角矩形的状态选择器
            Drawable selector = DrawableUtils.getStateListDrawable(
                    Color.rgb(r, g, b), color, UIUtils.dip2px(6));

            // 给TextView设置背景
            textView.setBackground(selector);

            // 必须设置点击事件, TextView按下后颜色才会变化
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(UIUtils.getContext(), wards,
                            Toast.LENGTH_SHORT).show();
                }
            });
            // 给自定义控件添加view对象
            flowLayout.addView(textView);

        }
        scrollView.addView(flowLayout);
        return scrollView;
    }

    @Override
    public ResultState onLoad() {
        HotProtocol protocol = new HotProtocol();
        data = protocol.getData(0);
        return check(data);
    }
}
