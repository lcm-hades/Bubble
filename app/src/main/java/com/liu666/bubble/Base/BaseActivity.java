package com.liu666.bubble.Base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;

import com.liu666.bubble.R;
import com.liu666.bubble.Utils.SystemUiUtil;

/**
 * Created by Administrator on 2018/4/25 0025.
 */

public abstract class BaseActivity extends Activity {
    private View mStatusBarView;

    LinearLayout mRoot;

    protected abstract int getLayout();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        // init();
    }

    void init(){
        mRoot = findViewById(R.id.root);
        if (mStatusBarView == null)
            mStatusBarView = SystemUiUtil.createStatusBarView(this);

        if ((mRoot.getChildAt(0) != mStatusBarView)) {
            mRoot.addView(mStatusBarView, 0);
        }
        boolean result = SystemUiUtil.setStatusBarMode(this, true);
        mStatusBarView.setBackgroundColor(result ? getResources().getColor(android.R.color.transparent) : getResources().getColor(android.R.color.transparent));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mStatusBarView.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

}
