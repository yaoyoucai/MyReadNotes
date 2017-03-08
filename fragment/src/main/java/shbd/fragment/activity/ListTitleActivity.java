package shbd.fragment.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import shbd.fragment.fragment.ListTitleFragment;

public class ListTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_title);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ListTitleFragment fragment = (ListTitleFragment) fragmentManager.findFragmentById(R.id.fl_content);
        if (fragment == null) {
            fragment=new ListTitleFragment();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_content, fragment);
            fragmentTransaction.commit();
        }
    }
}
