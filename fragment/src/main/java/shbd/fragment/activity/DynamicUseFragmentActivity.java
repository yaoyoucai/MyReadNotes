package shbd.fragment.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import shbd.fragment.fragment.ContentFragment;
import shbd.fragment.fragment.FriendsFragment;

public class DynamicUseFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnWeiXin;
    private Button mBtnFriends;

    private Fragment mFmFrends;
    private Fragment mFmContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_use_fragment);

        mBtnWeiXin = (Button) findViewById(R.id.btn_bottom_weixin);
        mBtnFriends = (Button) findViewById(R.id.btn_bottom_friends);

        mBtnWeiXin.setOnClickListener(this);
        mBtnFriends.setOnClickListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        mFmContent = new ContentFragment();
        fragmentTransaction.replace(R.id.fl_content, mFmContent);

        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (view.getId()) {
            case R.id.btn_bottom_weixin:
                if (mFmContent == null) {
                    mFmContent = new ContentFragment();
                }
                fragmentTransaction.replace(R.id.fl_content, mFmContent);
                break;
            case R.id.btn_bottom_friends:
                if (mFmFrends == null) {
                    mFmFrends = new FriendsFragment();
                }
                fragmentTransaction.replace(R.id.fl_content, mFmFrends);
                break;
        }
        fragmentTransaction.commit();
    }
}
