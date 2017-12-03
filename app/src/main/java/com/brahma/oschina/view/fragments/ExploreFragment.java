package com.brahma.oschina.view.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brahma.oschina.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("time", "public ExploreFragment() onCreateView");
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.layout_git, R.id.layout_gist, R.id.layout_soft,
            R.id.layout_scan, R.id.layout_shake,
            R.id.layout_nearby, R.id.layout_events})
    @Override
    public void onClick(View v) {

    }
}
