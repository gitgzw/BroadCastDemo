package com.syzc.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 不要在 onReceive()方法中添加过多的逻辑或者进行任何的耗时操作,因为在广播接收器中是不允许开启线程的,
 * 当 onReceive()方法运行了较长时间而没有结束时,程序就会报错。
 * 因此广播接收器更多的是扮演一种打开程序其他组件的角色,
 * 比如创建一条状态栏通知,或者启动一个服务等,这几个概念我们会在后面的章节中学到。
 */
public class StaticBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_broadcast);
    }

    public class BootCompleteReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "Boot Complete", Toast.LENGTH_LONG).show();
        }

    }
}
