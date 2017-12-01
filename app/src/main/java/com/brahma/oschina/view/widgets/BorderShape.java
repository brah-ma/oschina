package com.brahma.oschina.view.widgets;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.Shape;

public class BorderShape extends Shape {

    private RectF mRectF;

    public BorderShape(RectF rectF){
        mRectF=rectF;
    }
    @Override
    public void draw(Canvas canvas, Paint paint) {

        paint.setColor(Color.argb(0xFF,0xC8,0xC7,0xCC));
        //画四条边框
        if(mRectF.left>0){
            canvas.drawRect(0,0,mRectF.left,getHeight(),paint);
        }
        if(mRectF.top>0){
            canvas.drawRect(0,0,getWidth(),mRectF.top,paint);
        }
        if(mRectF.right>0){
            canvas.drawRect(getWidth()-mRectF.right,0,getWidth(),getHeight(),paint);
        }
        if(mRectF.bottom>0){
            canvas.drawRect(0,getHeight()-mRectF.bottom,getWidth(),getHeight(),paint);
        }

    }
}
