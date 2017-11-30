package com.brahma.oschina.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.brahma.oschina.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                redirectTo();
            }
        }.start();
    }

    private void redirectTo(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
