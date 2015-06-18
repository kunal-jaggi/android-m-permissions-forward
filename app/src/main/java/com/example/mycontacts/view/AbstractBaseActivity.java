package com.example.mycontacts.view;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

public abstract class AbstractBaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentResourceId());
        ButterKnife.inject(this);
    }

    protected abstract int getContentResourceId();
}
