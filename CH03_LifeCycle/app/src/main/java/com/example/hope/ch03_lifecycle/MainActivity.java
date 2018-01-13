package com.example.hope.ch03_lifecycle;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button myButton;
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("z这是onstart函数的输出内容");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("z这是onresume函数的 输出内容");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton=(Button)findViewById(R.id.myButton);
        System.out.println("这是ManinActivity页的oncreat函数的输出内容");
    //绑定监听器
        ButtonListener myButtonListener =new ButtonListener() ;
        myButton.setOnClickListener(myButtonListener);

        //播放背景音乐
        MediaPlayer myMediaPlayer=new MediaPlayer();
        myMediaPlayer.reset();
                try{
                    myMediaPlayer.setDataSource("/sdcard/ppap.mp3");
                }catch (IOException e){
                    e.printStackTrace();
                }
        myMediaPlayer.prepareAsync();
        myMediaPlayer.start();

    }
 class ButtonListener implements View.OnClickListener {
     @Override
     public void onClick(View v) {
         Intent myIntent=new Intent();
         myIntent.setClass(MainActivity.this,OtherActivity.class);
           startActivity(myIntent);

      }

 }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("这是ManinActivity页的ondestory函数的输出内容");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("这是ManinActivity页的onresatrt函数的输出内容");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //播放背景音乐
        MediaPlayer myMediaPlayer=new MediaPlayer();
        myMediaPlayer.reset();
        try{
            myMediaPlayer.setDataSource("/sdcard/ppap.mp3");
        }catch (IOException e){
            e.printStackTrace();
        }
        myMediaPlayer.prepareAsync();
        myMediaPlayer.start();
        System.out.println("这是ManinActivity页的onstop函数的输出内容");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("这是ManinActivity页的onpause函数的输出内容");
    }
}
