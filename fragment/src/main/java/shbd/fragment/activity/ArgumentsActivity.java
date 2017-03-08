package shbd.fragment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import shbd.fragment.fragment.ArgumentsFragment;

public class ArgumentsActivity extends AppCompatActivity {
    private ArgumentsFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arguments);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mFragment = (ArgumentsFragment) fragmentManager.findFragmentById(R.id.fl_content);

        if (mFragment == null) {
            mFragment = ArgumentsFragment.getInstance("data");
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fl_content, mFragment);
            fragmentTransaction.commit();
        }

    }
}
