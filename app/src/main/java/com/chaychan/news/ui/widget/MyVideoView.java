package com.chaychan.news.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by Administrator on 2018/5/7.
 */

public class MyVideoView extends VideoView {
    private int width;
    private int height;
    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public void setMeasure(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int width = getDefaultSize(getWidth(), widthMeasureSpec);
//        int height = getDefaultSize(getHeight(), heightMeasureSpec);
//        setMeasuredDimension(width, height);


//        int width = getDefaultSize(0, widthMeasureSpec);
//        int height = getDefaultSize(0, heightMeasureSpec);
//        setMeasuredDimension(width, height);


//// 默认高度，为了自动获取到focus
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = width;
//// 这个之前是默认的拉伸图像
//        if (this.width > 0 && this.height > 0) {
//            width = this.width;
//            height = this.height;
//        }
//        setMeasuredDimension(width, height);


    }
}
