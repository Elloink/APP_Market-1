package com.leostones.applicationmarket.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.leostones.applicationmarket.R;

/**
 * 作者：LeoStones
 * 时间：2016/11/23  17:15
 * 邮箱：
 * 说明: 自定义控件宽高比
 */
public class RatioLayout extends FrameLayout {

    private float ratio;

    public RatioLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RatioLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.RatioLayout);
        //id = 属性名_具体属性字段
        ratio = typedArray.getFloat(R.styleable.RatioLayout_ratio, -1);
        //回收typedArray 提高性能
        typedArray.recycle();
        System.out.println("Retio:" + ratio);
    }

    public RatioLayout(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // MeasureSpec.EXACTLY 确定值, 比如把宽高值写死,或者match_parent
        // MeasureSpec.AT_MOST 至多, 能撑多大就多大, 类似wrap_content
        // MeasureSpec.UNSPECIFIED 未指定大小

        if (widthMode == MeasureSpec.EXACTLY
                && heightMode != MeasureSpec.EXACTLY && ratio != 0) {
            // 1. 根据布局宽度推算图片宽度
            int imageWidth = widthSize - getPaddingLeft() - getPaddingRight();
            // 2. 根据图片宽度和宽高比,推算图片高度
            int imageHeight = (int) (imageWidth / ratio);
            // 3. 根据图片高度, 推算布局高度
            heightSize = imageHeight + getPaddingTop() + getPaddingBottom();
            // 4. 根据布局高度, 推算heightMeasureSpec
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                    MeasureSpec.EXACTLY);
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
