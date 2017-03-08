package shbd.fragment.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import shbd.fragment.activity.ContentActivity;
import shbd.fragment.activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTitleFragment extends ListFragment {
    public static final int REQUEST_DETAIL = 0X110;
    private List<String> mTitles = Arrays.asList("hello", "world", "android");

    private ArrayAdapter<String> mAdapter;

    private int currentPosition;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(mAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext()
                , R.layout.list_item, mTitles));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        this.currentPosition = position;
        Intent intent = new Intent(getActivity(), ContentActivity.class);
        intent.putExtra(ContentFragment.ARGUMENT, mTitles.get(position));
        startActivityForResult(intent, REQUEST_DETAIL);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETAIL && resultCode == Activity.RESULT_OK) {
            mTitles.set(currentPosition, mTitles.get(currentPosition) + " -- " + data.getStringExtra(ContentFragment.RESPONSE));
            mAdapter.notifyDataSetChanged();
        }
    }
}
