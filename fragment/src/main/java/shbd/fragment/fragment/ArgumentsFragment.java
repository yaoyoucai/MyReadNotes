package shbd.fragment.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shbd.fragment.activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArgumentsFragment extends Fragment {
    private TextView mTextView;


    private static final String ARGUMENTS = "arguments";

    private String argument;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            argument = bundle.getString(ARGUMENTS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_arguments, container, false);
        mTextView = (TextView) view.findViewById(R.id.textview);
        if (!TextUtils.isEmpty(argument)) {
            mTextView.setText(argument);
        }
        return view;
    }

    public static ArgumentsFragment getInstance(String arguments) {
        ArgumentsFragment fragment = new ArgumentsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENTS, arguments);
        fragment.setArguments(bundle);
        return fragment;
    }
}
