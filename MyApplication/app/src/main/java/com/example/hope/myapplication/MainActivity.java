package com.example.hope.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton=(Button)findViewById(R.id.myButton);
        //绑定监听器
        ButtonListener myButttonlister=new ButtonListener();
        myButton.setOnClickListener(myButttonlister);

    }

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent myIntent=new Intent();
            myIntent.setClass(MainActivity.this.Other2Activity.Class);
            startActivity(myIntent);
        }
    }

}
