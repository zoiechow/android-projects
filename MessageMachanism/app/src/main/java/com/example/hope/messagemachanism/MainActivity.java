package com.example.hope.messagemachanism;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textView;
    private Button button;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.t1);
        button=(Button)findViewById(R.id.b1);

        ButtonListener btl=new ButtonListener();
        button.setOnClickListener(btl);

        handler=new handler() ;
    }

    /*class  NewThread extends Thread{
        @Override
        public void run() {
            Thread.
            try {
                sleep(60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textView.setText("这是来自子线程修改的文字");
            super.run();
        }
    }*/
   /* class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            textView.setText("这是来自子线程修改的文字");

        }
    }
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Message msg=handler.obtainMessage();
            msg.what=100;
            handler.sendMessage(msg);
        }
    }
 class handler extends  Handler{
        @Override
        public void handleMessage(Message msg) {
            int score=msg.what;
            System.out.println("值为"+score);
            super.handleMessage(msg);
        }
    }*/

    class handler extends  Handler{
        @Override
        public void handleMessage(Message msg) {
            System.out.println("这是从handle返回的内容");

        }
    }
    class NewThread extends Thread{
        @Override
        public void run() {
            System.out.println("这是来自NewThread的内容"+Thread.currentThread().getName());
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s="这是从网络获取的数据";
            Message msg=handler.obtainMessage();
            msg.obj=s;
            handler.sendMessage(msg);
            super.run();
        }
    }
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Thread thread =new NewThread();
            thread.start();
        }
    }
}
