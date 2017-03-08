package shbd.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import shbd.fragment.activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener {
    private Button mBtnGoFragmentTwo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        mBtnGoFragmentTwo = (Button) view.findViewById(R.id.btn_fragment_one);

        mBtnGoFragmentTwo.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (getActivity() instanceof FragmentOneBtnOnclickListener) {
            ((FragmentOneBtnOnclickListener) getActivity()).onOneBtnClick();
        }
    }

    public interface FragmentOneBtnOnclickListener {
        void onOneBtnClick();
    }
}
