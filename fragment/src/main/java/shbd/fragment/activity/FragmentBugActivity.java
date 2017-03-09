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

/**
 * 项目名称：MyReadNotes
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/9 13:42
 * 修改人：yh
 * 修改时间：2017/3/9 13:42
 * 修改备注：
 */
public class FragmentBugActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnWeiXin;
    private Button mBtnFriends;

    private Fragment mFmFrends;
    private Fragment mFmContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bug);

        mBtnWeiXin = (Button) findViewById(R.id.btn_bottom_weixin);
        mBtnFriends = (Button) findViewById(R.id.btn_bottom_friends);

        mBtnWeiXin.setOnClickListener(this);
        mBtnFriends.setOnClickListener(this);

        setDefaultFragment(savedInstanceState);
    }

    private void setDefaultFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            mFmContent = new ContentFragment();
            fragmentTransaction.replace(R.id.fl_content, mFmContent);

            fragmentTransaction.commit();
        }
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
