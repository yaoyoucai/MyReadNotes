package com.animation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnViewAnim;
    private Button mBtnFrameAnim;
    private Button mBtnPropertyAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnViewAnim = (Button) findViewById(R.id.btn_view_anim);
        mBtnFrameAnim = (Button) findViewById(R.id.btn_frame_anim);
        mBtnPropertyAnim = (Button) findViewById(R.id.btn_property_anim);

        mBtnViewAnim.setOnClickListener(this);
        mBtnFrameAnim.setOnClickListener(this);
        mBtnPropertyAnim.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_view_anim:
                intent.setClass(this, ViewAnimActivity.class);
                break;
            case R.id.btn_frame_anim:
                intent.setClass(this, FrameAnimActivity.class);
                break;
            case R.id.btn_property_anim:
                intent.setClass(this, PropertyAnimActivity.class);
                break;
        }
        startActivity(intent);
    }
}
