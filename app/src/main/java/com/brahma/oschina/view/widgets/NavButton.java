package com.brahma.oschina.view.widgets;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.brahma.oschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NavButton extends FrameLayout {

    @BindView(R.id.nav_icon)
    ImageView mIvIcon;
    @BindView(R.id.nav_title)
    TextView mTvTitle;
    @BindView(R.id.nav_dot)
    TextView mTvDot;

    private Fragment mFragment;
    private Class<?> mClass;

    public NavButton(Context context){
        this(context,null);

    }
    public NavButton(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        init();
    }

    private void init(){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.layout_nav_buttom,this,true);
        ButterKnife.bind(this,view);

    }
    public void setSelected(boolean selected){
        mIvIcon.setSelected(selected);
        mTvTitle.setSelected(selected);
    }

    public void showRedDot(int count){
        mTvDot.setVisibility(count>0?VISIBLE:INVISIBLE);
        mTvDot.setText(String.valueOf(count));
    }

    public void init(@DrawableRes int resId, @StringRes int strId, Class<?> cls){
        mIvIcon.setImageResource(resId);
        mTvTitle.setText(strId);
        mClass=cls;
    }


}
