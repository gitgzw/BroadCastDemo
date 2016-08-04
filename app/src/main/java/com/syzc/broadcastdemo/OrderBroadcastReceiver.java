package com.syzc.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 有序广播
 * Created by chenshungang on 16/8/4.
 */
public class OrderBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in OrderBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }

}
