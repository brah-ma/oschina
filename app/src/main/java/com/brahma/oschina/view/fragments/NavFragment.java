package com.brahma.oschina.view.fragments;


import android.app.Fragment;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.brahma.oschina.R;
import com.brahma.oschina.view.widgets.BorderShape;
import com.brahma.oschina.view.widgets.NavButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class NavFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.nav_btn_news)
    NavButton mNavNews;
    @BindView(R.id.nav_btn_tweet)
    NavButton mNavTweet;
    @BindView(R.id.nav_btn_explore)
    NavButton mNavExplore;
    @BindView(R.id.nav_btn_my)
    NavButton mNavMy;
    @BindView(R.id.nav_btn_tweet_pub)
    ImageView mNavPub;

    private int mNavId;
    private NavButton mNavBtn;
    private int mNavIndex;

    public interface OnBtnSelectedListener{
        void onBtnSelected(int index);
    }

    private OnBtnSelectedListener mListener;

    public void setOnBtnSelectedListener(OnBtnSelectedListener onBtnSelectedListener){
        mListener=onBtnSelectedListener;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_nav, container, false);
        ButterKnife.bind(this,view);

        mNavNews.init(R.drawable.nav_tab_news,R.string.nav_title_news);
        mNavTweet.init(R.drawable.nav_tab_tweet,R.string.nav_title_tweet);
        mNavExplore.init(R.drawable.nav_tab_explore,R.string.nav_title_explore);
        mNavMy.init(R.drawable.nav_tab_my,R.string.nav_title_my);
        mNavBtn=mNavNews;

        mNavNews.setSelected(true);


        ShapeDrawable shapeDrawable=new ShapeDrawable(new BorderShape(new RectF(0,1,0,0)));
        view.setBackgroundDrawable(shapeDrawable);

        return view;
    }

    @OnClick({R.id.nav_btn_news,R.id.nav_btn_tweet,R.id.nav_btn_explore,R.id.nav_btn_my,R.id.nav_btn_tweet_pub})
    @Override
    public void onClick(View v) {

        if(v.getId()==mNavId){
            return;
        }
        mNavId=v.getId();

        mNavBtn.setSelected(false);
        switch (v.getId()){
            case R.id.nav_btn_news:
                mNavNews.setSelected(true);
                mNavBtn=mNavNews;
                mNavIndex=1;
                break;
            case R.id.nav_btn_tweet:
                mNavTweet.setSelected(true);
                mNavBtn=mNavTweet;
                mNavIndex=2;
                break;
            case R.id.nav_btn_explore:
                mNavExplore.setSelected(true);
                mNavBtn=mNavExplore;
                mNavIndex=4;
                break;
            case R.id.nav_btn_my:
                mNavMy.setSelected(true);
                mNavBtn=mNavMy;
                mNavIndex=5;
                break;
            case R.id.nav_btn_tweet_pub:
                mNavPub.setSelected(true);
                mNavIndex=3;
                break;
        }

        if(mListener!=null){
            mListener.onBtnSelected(mNavIndex);
        }


    }
}
