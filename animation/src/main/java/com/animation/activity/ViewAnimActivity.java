package com.animation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class ViewAnimActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnRotate;
    private Button mBtnScale;
    private Button mBtnTranslate;
    private Button mBtnAlpha;
    private Button mBtnAll;

    private TextView mTvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_anim);

        mBtnRotate = (Button) findViewById(R.id.rotate);
        mBtnScale = (Button) findViewById(R.id.scale);
        mBtnTranslate = (Button) findViewById(R.id.translate);
        mBtnAlpha = (Button) findViewById(R.id.alpha);
        mBtnAll = (Button) findViewById(R.id.all);

        mTvTest = (TextView) findViewById(R.id.tv_test);

        mBtnRotate.setOnClickListener(this);
        mBtnScale.setOnClickListener(this);
        mBtnTranslate.setOnClickListener(this);
        mBtnAlpha.setOnClickListener(this);
        mBtnAll.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rotate:
                rotate();
                break;
            case R.id.scale:
                scale();
                break;
            case R.id.translate:
                translate();
                break;
            case R.id.alpha:
                alpha();
                break;
            case R.id.all:
                all();
                break;
        }
    }

    private void rotate() {
        //1.xml文件
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        mTvTest.startAnimation(animation);

        //2.代码
       /* RotateAnimation rotateAnimation = new RotateAnimation(0, 360, mTvTest.getWidth() / 2, mTvTest.getHeight() / 2);
        rotateAnimation.setDuration(1000);
        mTvTest.startAnimation(rotateAnimation);*/
    }

    private void scale() {
        //1.xml文件
     /*   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        mTvTest.startAnimation(animation);
*/
        //2.代码
        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 2f, 1f, 2f, mTvTest.getWidth() / 2, mTvTest.getHeight() / 2);
        scaleAnimation.setDuration(1000);
        mTvTest.startAnimation(scaleAnimation);
    }

    private void translate() {
        //1.xml文件
      /*  Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
        mTvTest.startAnimation(animation);*/

        //2.代码
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 500);
        translateAnimation.setDuration(1000);
        mTvTest.startAnimation(translateAnimation);
    }

    private void alpha() {
        //1.xml文件
       /* Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
        mTvTest.startAnimation(animation);*/

        //2.代码
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1000);
        mTvTest.startAnimation(alphaAnimation);

    }


    private void all() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.all);
        mTvTest.startAnimation(animation);
    }
}
