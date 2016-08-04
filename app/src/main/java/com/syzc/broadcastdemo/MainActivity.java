package com.syzc.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_send;
    private Button btn_send_local;
    private Button btn_force_offline;

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send_local = (Button) findViewById(R.id.btn_send_local);
        btn_send.setOnClickListener(this);
        btn_send_local.setOnClickListener(this);
        btn_force_offline = (Button) findViewById(R.id.btn_force_offline);
        btn_force_offline.setOnClickListener(this);

        /**
         * 注册本地广播接收器
         */
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.syzc.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                Intent intent = new Intent("com.syzc.MY_BROADCAST");
                /**
                 * 发送自定义广播
                 */
//                sendBroadcast(intent);

                /**
                 * 发送有序广播
                 * 优先级比较高的 广播接收器就可以先收到广播
                 */
                sendOrderedBroadcast(intent, null);
                break;
            case R.id.btn_send_local:
                Intent intent1 = new Intent("com.syzc.LOCAL_BROADCAST");
                /**
                 * 发送本地广播
                 */
                localBroadcastManager.sendBroadcast(intent1);
                break;
            case R.id.btn_force_offline:
                Intent intent2 = new Intent("com.syzc.FORCE_OFFLINE");
                sendBroadcast(intent2);
                break;
        }
    }

    /**
     * 本地广播
     */
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "received local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
