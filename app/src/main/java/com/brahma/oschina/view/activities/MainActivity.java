package com.brahma.oschina.view.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.brahma.oschina.R;
import com.brahma.oschina.view.fragments.ExploreFragment;
import com.brahma.oschina.view.fragments.NavFragment;
import com.brahma.oschina.view.fragments.NewsFragment;
import com.brahma.oschina.view.fragments.TweetFragment;
import com.brahma.oschina.view.fragments.UserInfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements NavFragment.OnBtnSelectedListener {
    
    @BindView(R.id.layout_content)
    FrameLayout mLayoutContent;

    private NavFragment mNavFrag;
    
    private NewsFragment mFragNews;
    private TweetFragment mFragTweet;
    private ExploreFragment mFragExplore;
    private UserInfoFragment mFragUser;
    
    private int mIndex=1;
    private Fragment mFragment;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ButterKnife.bind(this);
        
        mNavFrag=(NavFragment) getFragmentManager().findFragmentById(R.id.frag_nav);
        mNavFrag.setOnBtnSelectedListener(this);

        mFragNews=new NewsFragment();
        mFragTweet=new TweetFragment();
        mFragExplore=new ExploreFragment();
        mFragUser=new UserInfoFragment();
        
        
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.add(R.id.layout_content,mFragNews);
        transaction.commit();
        mFragment=mFragNews;
        
        
    }

    @Override
    public void onBtnSelected(int index) {
        if(mIndex==index){
            return;
        }
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.hide(mFragment);

        switch (index){//底部四个tab被点击
            case 1:
                mFragment=mFragNews;
                mIndex=1;
                break;
            case 2:
                mFragment=mFragTweet;
                mIndex=2;
                break;
            case 3:

                mIndex=3;
                break;
            case 4:
                mFragment=mFragExplore;
                mIndex=4;
                break;
            case 5:
                mIndex=5;
                mFragment=mFragUser;
                break;
        }
        if(mFragment.isAdded()){
            transaction.show(mFragment);
        }else {
            transaction.add(R.id.layout_content,mFragment);
        }
        transaction.commit();
    }
}
