package shbd.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import shbd.fragment.activity.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTwo extends Fragment implements View.OnClickListener {
    private Button mBtnFragmentTwo;

    private OnFragmentTwoBtnClick mOnclick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        mBtnFragmentTwo = (Button) view.findViewById(R.id.btn_fragment_two);
        mBtnFragmentTwo.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (mOnclick != null) {
            mOnclick.onBtnTwoClick();
        }
    }

    public interface OnFragmentTwoBtnClick {
        void onBtnTwoClick();
    }

    public void setOnFragementTwoBtnClick(OnFragmentTwoBtnClick onFragementTwoBtnClick) {
        this.mOnclick = onFragementTwoBtnClick;
    }
}
