package shbd.fragment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import shbd.fragment.fragment.ContentFragment;

public class ContentActivity extends AppCompatActivity {
    private ContentFragment mContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        FragmentManager fm = getSupportFragmentManager();
        mContentFragment = (ContentFragment) fm.findFragmentById(R.id.fl_content);

        if (mContentFragment == null) {
            String title = getIntent().getStringExtra(ContentFragment.ARGUMENT);
            mContentFragment = ContentFragment.newInstance(title);
            fm.beginTransaction().add(R.id.fl_content, mContentFragment).commit();
        }
    }
}
