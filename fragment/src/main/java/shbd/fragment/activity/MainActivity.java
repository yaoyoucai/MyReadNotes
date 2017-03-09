package shbd.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mFragmentBug;
    private Button mBtnUseStaticFragment;
    private Button mBtnUseDynamicFragment;
    private Button mBtnStackFragment;
    private Button mBtnAboutFragmentArguments;
    private Button mBtnAboutStartActivityForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentBug = (Button) findViewById(R.id.btn_fragment_bug);
        mBtnUseStaticFragment = (Button) findViewById(R.id.btn_stastic_fragment);
        mBtnUseDynamicFragment = (Button) findViewById(R.id.btn_dynamic_fragment);
        mBtnStackFragment = (Button) findViewById(R.id.btn_stack_fragment);
        mBtnAboutFragmentArguments = (Button) findViewById(R.id.btn_about_fragment_arguments);
        mBtnAboutStartActivityForResult = (Button) findViewById(R.id.btn_about_start_activity_for_result);

        mBtnUseStaticFragment.setOnClickListener(this);
        mFragmentBug.setOnClickListener(this);
        mBtnUseDynamicFragment.setOnClickListener(this);
        mBtnStackFragment.setOnClickListener(this);
        mBtnAboutFragmentArguments.setOnClickListener(this);
        mBtnAboutStartActivityForResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_fragment_bug:
                intent.setClass(this, FragmentBugActivity.class);
                break;
            case R.id.btn_stastic_fragment:
                intent.setClass(this, StaticUseFragmentActivity.class);
                break;
            case R.id.btn_dynamic_fragment:
                intent.setClass(this, DynamicUseFragmentActivity.class);
                break;
            case R.id.btn_stack_fragment:
                intent.setClass(this, StackFragmentActivity.class);
                break;
            case R.id.btn_about_fragment_arguments:
                intent.setClass(this, ArgumentsActivity.class);
                break;
            case R.id.btn_about_start_activity_for_result:
                intent.setClass(this, ListTitleActivity.class);
                break;
        }
        startActivity(intent);
    }
}
