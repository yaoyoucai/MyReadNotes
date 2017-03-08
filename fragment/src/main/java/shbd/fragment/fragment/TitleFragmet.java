package shbd.fragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import shbd.fragment.activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragmet extends Fragment implements View.OnClickListener {
    private View mView;

    private ImageView mIvReturn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_title, container, false);

        mIvReturn = (ImageView) mView.findViewById(R.id.iv_return);

        mIvReturn.setOnClickListener(this);
        return mView;
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), "onclick", Toast.LENGTH_SHORT).show();
    }
}
