package com.liu666.bubble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.liu666.bubble.Base.BaseActivity;

import java.lang.ref.WeakReference;

public class StartPageActivity extends BaseActivity {
    Handler handler;
    MyRunnable myRunnable;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
        myRunnable = new MyRunnable(this);
        handler.postDelayed(myRunnable, 3000);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_start_page;
    }

    public static class MyRunnable implements Runnable{
        WeakReference<StartPageActivity> ac;
        public MyRunnable(StartPageActivity a){
            ac = new WeakReference<StartPageActivity>(a);
        }

        @Override
        public void run() {
            StartPageActivity activity = ac.get();
            if (activity != null){
                Intent main = new Intent(activity, MainActivity.class);
                activity.startActivity(main);
                activity.finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(myRunnable);
    }
}
