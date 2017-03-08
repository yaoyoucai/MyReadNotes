package shbd.fragment.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class ContentFragment extends Fragment {

    private String mArgument;
    public static final String ARGUMENT = "argument";
    public static final String RESPONSE = "response";

    public static final int REQUEST_EVALUATE = 0x110;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mArgument = bundle.getString(ARGUMENT);
        }

    }

    public static ContentFragment newInstance(String argument) {
        Bundle bundle = new Bundle();
        bundle.putString(ARGUMENT, argument);
        ContentFragment contentFragment = new ContentFragment();
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Random random = new Random();
        TextView tv = new TextView(getActivity());
        tv.setText(mArgument);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.argb(random.nextInt(100),
                random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EvaluateFragment fragment = new EvaluateFragment();
                fragment.setTargetFragment(ContentFragment.this, REQUEST_EVALUATE);
                fragment.show(getFragmentManager(), EvaluateFragment.EVALUATE_FRAGMENT);
            }
        });
        return tv;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_EVALUATE) {
            String evaluate = data.getStringExtra(EvaluateFragment.RESPONSE_VALUATE);
            Intent intent = new Intent();
            intent.putExtra(RESPONSE, evaluate);
            getActivity().setResult(Activity.RESULT_OK, intent);
        }
    }

}
