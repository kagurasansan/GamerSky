package com.kagurasansan.gamersky;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.gamersky.kagurasansan.base.moduleinterface.route.MyRouter;
import com.gamersky.kagurasansan.base.moduleinterface.route.RouterConstants;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler = new Handler(getMainLooper());

    }


    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MyRouter.newInstance(RouterConstants.MAIN_HOME).navigation();
                finish();
            }
        }, 1500);
    }
}
