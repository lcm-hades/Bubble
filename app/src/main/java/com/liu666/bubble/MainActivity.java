package com.liu666.bubble;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.liu666.bubble.Base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
