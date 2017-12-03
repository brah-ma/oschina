package com.brahma.oschina.view.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 10750 on 2017/12/3.
 */

public class SolarSystemView extends View {

    private int mRawRadius;
    private int mWidth;
    private int mHeight;
    private int mMaxRadius;

    private float mPivotX;
    private float mPivotY;

    private int mStrokeWidth=2;
    private int mTrakeColor=0XFF6FDB94;

    private List<Planet> mListPlanet;

    private Paint mPaint;

    private int mPaintCount=1;

    public SolarSystemView(Context context){
        this(context,null);
    }
    public SolarSystemView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(mListPlanet==null||mListPlanet.size()==0){
            return;
        }

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        for(Planet planet:mListPlanet){
            canvas.drawCircle(mPivotX,mPivotY,planet.getRadius(),mPaint);
        }
        for(Planet planet:mListPlanet){
            float angle;
            if(planet.isClockwise()){
                angle=planet.getStartAngle()+mPaintCount*planet.getRunAngle()%360;
            }else{
                angle=360-planet.getStartAngle()+mPaintCount*planet.getRunAngle()%360;
            }
            double planetX=Math.cos(angle)*planet.getRadius()+mPivotX;
            double planetY=Math.sin(angle)*planet.getRadius()+mPivotY;
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float)planetX,(float)planetY,planet.getSelfRadius(),mPaint);
        }
        mPaintCount++;

        postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        },40);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        mWidth=getWidth();
        mHeight=getHeight();
        mMaxRadius=Math.max(mWidth,mHeight)/2;

        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(mTrakeColor);

    }

    private void init(){//初始化运行星球
        if(mRawRadius==0){
            return;
        }
        mListPlanet=new ArrayList<>();
        int deltaRadius=40;
        Random random=new Random();
        for(int radius=mRawRadius+deltaRadius;radius<=mMaxRadius;deltaRadius=(int)(deltaRadius*1.4),radius+=deltaRadius){
              Planet planet=new Planet();
              planet.setRadius(radius);
              planet.setRateTimes((random.nextInt(5)+1)*3);
              planet.setClockwise(random.nextBoolean());
              mListPlanet.add(planet);
        }

    }
    public void init(float x,float y,int radius){
        mPivotX=x;
        mPivotY=y;
        mRawRadius=radius;
        init();
        invalidate();
    }

    public static class Planet{

        private int mRadius;//公转半径
        private int mSelfRadius=9;//自身半径
        private int mTrackWidth=1;//轨迹圆宽度

        private int mStartAngle;//起始角度
        private float mAngleRate=1.0f/360;//基础公转速度，以转过角度表示
        private int mRateTimes=1;//基础公转速度mAngleRate的倍成因子

        private boolean mClockwise=true;

        public float getRunAngle(){//每次转过的角度
            return mAngleRate*mRateTimes;
        }

        public void setClockwise(boolean clockwise){
            mClockwise=clockwise;
        }
        public boolean isClockwise(){
            return mClockwise;
        }

        public int getRadius() {
            return mRadius;
        }

        public void setRadius(int mRadius) {
            this.mRadius = mRadius;
        }

        public int getSelfRadius() {
            return mSelfRadius;
        }

        public void setSelfRadius(int mSelfRadius) {
            this.mSelfRadius = mSelfRadius;
        }

        public int getTrackWidth() {
            return mTrackWidth;
        }

        public void setTrackWidth(int mTrackWidth) {
            this.mTrackWidth = mTrackWidth;
        }

        public int getStartAngle() {
            return mStartAngle;
        }

        public void setStartAngle(int mStartAngle) {
            this.mStartAngle = mStartAngle;
        }

        public float getAngleRate() {
            return mAngleRate;
        }

        public void setAngleRate(float mAngleRate) {
            this.mAngleRate = mAngleRate;
        }

        public int getRateTimes() {
            return mRateTimes;
        }

        public void setRateTimes(int mRateTimes) {
            this.mRateTimes = mRateTimes;
        }
    }
}
