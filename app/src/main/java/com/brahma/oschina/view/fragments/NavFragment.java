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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_nav, container, false);
        ButterKnife.bind(this,view);

        mNavNews.init(R.drawable.nav_tab_news,R.string.nav_title_news,NewsFragment.class);
        mNavTweet.init(R.drawable.nav_tab_tweet,R.string.nav_title_tweet,TweetFragment.class);
        mNavExplore.init(R.drawable.nav_tab_explore,R.string.nav_title_explore,ExploreFragment.class);
        mNavMy.init(R.drawable.nav_tab_my,R.string.nav_title_my,UserInfoFragment.class);
        mNavBtn=mNavNews;

        ShapeDrawable shapeDrawable=new ShapeDrawable(new BorderShape(new RectF(0,1,0,0)));
        view.setBackgroundDrawable(shapeDrawable);

        return view;
    }

    @OnClick({R.id.nav_btn_news,R.id.nav_btn_tweet,R.id.nav_btn_explore,R.id.nav_btn_my,R.id.nav_btn_tweet_pub})
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.nav_btn_tweet_pub){
            return;
        }

        if(v.getId()==mNavId){
            return;
        }
        mNavId=v.getId();

        mNavBtn.setSelected(false);
        switch (v.getId()){
            case R.id.nav_btn_news:
                mNavNews.setSelected(true);
                mNavBtn=mNavNews;
                break;
            case R.id.nav_btn_tweet:
                mNavTweet.setSelected(true);
                mNavBtn=mNavTweet;
                break;
            case R.id.nav_btn_explore:
                mNavExplore.setSelected(true);
                mNavBtn=mNavExplore;
                break;
            case R.id.nav_btn_my:
                mNavMy.setSelected(true);
                mNavBtn=mNavMy;
                break;
            case R.id.nav_btn_tweet_pub:
                mNavPub.setSelected(true);
                break;
        }


    }
}
