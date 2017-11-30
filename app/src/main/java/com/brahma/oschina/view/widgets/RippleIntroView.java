package com.brahma.oschina.view.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by 10750 on 2017/11/30.
 */

public class RippleIntroView extends RelativeLayout {

    private Paint mPaint;
    private Path mPath;

    /*
    相邻两条雷达波纹之间的距离
     */
    private int mInterval=20;
    /*
    同一条雷达波纹每次扩散的距离是2
    count是波纹扩散次数
     */
    private int count=0;
    private int mMaxRadius=70;

    public RippleIntroView(Context context){
        this(context,null);
    }
    public RippleIntroView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        init();
    }
    private void init(){
        mPaint=new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2.0f);

        mPath=new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        View ivPlus=getChildAt(0);//雷达动画中心imageView
        View ivIntro=getChildAt(1);//文字介绍imageView

        int ivPlusWidth=ivPlus.getWidth();//ivPlus应该是正方形，ivPlusWidth=ivPlusHeight
        int ivPlusHeight=ivPlus.getHeight();
        int radius=ivPlusWidth>ivPlusHeight?ivPlusWidth/2:ivPlusHeight/2;

        float centerX=ivPlus.getX()+ivPlusWidth/2;//雷达动画圆点坐标
        float centerY=ivPlus.getY()+ivPlusHeight/2;

        int ivIntroWidth=ivIntro.getWidth();
        int ivIntroHeight=ivIntro.getHeight();

        float ivIntroX=ivIntro.getX();
        float ivIntroY=ivIntro.getY();

        mPath.reset();//用三个点定义二次贝塞尔曲线
        mPath.moveTo(centerX,centerY+radius+mInterval);//右上点
        //右下点，左下点
        mPath.quadTo(centerX,ivIntroY-mInterval,ivIntroX+ivIntroWidth*0.618f,ivIntroY-mInterval);

        mPaint.setStyle(Paint.Style.FILL);//画弧线右上一小圆点
        mPaint.setAlpha(255);
        canvas.drawCircle(centerX,centerY+radius+mInterval,6,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);//画弧线
        canvas.drawPath(mPath,mPaint);

        for(int eachRadius=count;eachRadius<=mMaxRadius;eachRadius+=mInterval){
            mPaint.setAlpha(255*(mMaxRadius-eachRadius)/mMaxRadius);
            canvas.drawCircle(centerX,centerY,(float) (radius+eachRadius),mPaint);
        }

        count+=2;
        count%=mInterval;

        postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        },80);

    }
}
