package com.example.hope.ch03_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    private Button myButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton=(Button)findViewById(R.id.button);
        myButton1=(Button)findViewById(R.id.button1);
        //绑定 监听器
        ButtonListener myButttonlister=new ButtonListener();
    }


    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent myIntent=new Intent();

            myIntent.setClass(MainActivity.class.OtherActivity);
            myIntent.setClass(MainActivity.this.MainActivity.Class);
            startActivity(myIntent);
        }
    }
}
