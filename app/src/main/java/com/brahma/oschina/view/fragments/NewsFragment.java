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

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        super();
        Log.i("time","public NewsFragment()");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("time","public NewsFragment() onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("time","public NewsFragment() onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("time","public NewsFragment() onActivityCreated");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("time","public NewsFragment() onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("time","public NewsFragment() onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("time","public NewsFragment() onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("time","public NewsFragment() onDetach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Log.i("time","public NewsFragment() onCreateView");
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

}
