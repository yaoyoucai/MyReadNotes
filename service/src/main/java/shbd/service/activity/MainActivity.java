package shbd.service.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import shbd.service.service.DownLoadService;

public class MainActivity extends AppCompatActivity {
    private DownloadCompleteReceiver mReceiver;
    public static final String ACTION_DOWNLOAD_COMPLETE = "shbd.service.activity.download_complete";
    int i = 0;

    private LinearLayout mLlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLlContainer = (LinearLayout) findViewById(R.id.ll_container);

        initReceiver();
    }

    private void initReceiver() {
        mReceiver = new DownloadCompleteReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(mReceiver, intentFilter);
    }

    public void downloadImg(View view) {
        String path = (++i) + ".png";
        DownLoadService.startDownload(this, path);

        TextView textView = new TextView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(lp);
        textView.setText(path + "start download");
        textView.setTextColor(Color.BLACK);
        textView.setTag(path);
        mLlContainer.addView(textView);
    }

    private class DownloadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String path = intent.getStringExtra(DownLoadService.IMG_PATH);
            TextView textView = (TextView) mLlContainer.findViewWithTag(path);
            textView.setText(path + " download complete");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
