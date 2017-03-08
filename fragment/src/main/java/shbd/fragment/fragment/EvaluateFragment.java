package shbd.fragment.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvaluateFragment extends DialogFragment {
    private String[] items = new String[]{"good", "bad", "normal"};

    public static final String RESPONSE_VALUATE = "response_valuate";

    public static final String EVALUATE_FRAGMENT = "evaluate_fragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("title").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setResult(i);
            }
        });
        return builder.create();
    }

    private void setResult(int position) {
        if (getTargetFragment() == null)
            return;
        Intent intent = new Intent();
        intent.putExtra(RESPONSE_VALUATE, items[position]);
        getTargetFragment().onActivityResult(ContentFragment.REQUEST_EVALUATE, Activity.RESULT_OK, intent);
    }
}
