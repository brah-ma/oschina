package com.brahma.oschina.view.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.brahma.oschina.R;
import com.brahma.oschina.view.widgets.SolarSystemView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserInfoFragment extends Fragment {


    @BindView(R.id.ivUser)
    ImageView ivUser;
    @BindView(R.id.view_solar_system)
    SolarSystemView mSolarView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_user_info, container, false);
        ButterKnife.bind(this,view);
        view.post(new Runnable() {
            @Override
            public void run() {
                float x=ivUser.getX();
                float y=ivUser.getY();
                int width=ivUser.getWidth();
                int height=ivUser.getHeight();
                int w=Math.max(width,height);
                float pivotX=x+width/2;
                float pivotY=y+height/2;

                mSolarView.init(pivotX,pivotY,w/2);
            }
        });
        return view;
    }


}
