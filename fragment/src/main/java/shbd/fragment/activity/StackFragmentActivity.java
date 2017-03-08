package shbd.fragment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import shbd.fragment.fragment.FragmentOne;
import shbd.fragment.fragment.FragmentThree;
import shbd.fragment.fragment.FragmentTwo;

public class StackFragmentActivity extends AppCompatActivity implements FragmentOne.FragmentOneBtnOnclickListener, FragmentTwo.OnFragmentTwoBtnClick {
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_fragment);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        mFragmentOne = new FragmentOne();
        fragmentTransaction.add(R.id.fl_content, mFragmentOne, "FRAGMENT_ONE");

        fragmentTransaction.commit();


    }

    @Override
    public void onOneBtnClick() {
        if (mFragmentTwo == null) {
            mFragmentTwo = new FragmentTwo();
            mFragmentTwo.setOnFragementTwoBtnClick(this);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fl_content, mFragmentTwo, "FRAGMENT_TWO");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBtnTwoClick() {
        if (mFragmentThree == null) {
            mFragmentThree = new FragmentThree();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.hide(mFragmentTwo);
        fragmentTransaction.add(R.id.fl_content, mFragmentThree, "FRAGMENT_THREE");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
