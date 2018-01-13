package com.example.hope.ch03_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        System.out.println("这是在OTHERACtivity的oncreat函数的输出内容");
    }

    protected void onStart() {
        super.onStart();
        System.out.println("这是在OTHERACtivity的onstart函数的输出内容");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("这是在OTHERACtivity的onresume函数的输出内容");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("这是在OTHERACtivity的onpause函数的输出内容");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("这是在OTHERACtivity的onstop函数的输出内容");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("这是在OTHERACtivity的ondestory函数的输出内容");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("这是在OTHERACtivity的onrestart函数的输出内容");
    }
}
