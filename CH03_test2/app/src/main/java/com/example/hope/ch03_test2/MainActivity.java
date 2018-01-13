package com.example.hope.ch03_test2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button1;
    private Button button2;
    private int k=15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        ButtonListenter mbtListenter1 = new ButtonListenter();
        button1.setOnClickListener(mbtListenter1);

        button2 = (Button) findViewById(R.id.button2);
        ButtonListenter mbtListenter2 = new ButtonListenter();
        button2.setOnClickListener(mbtListenter2);

        textView=(TextView) findViewById(R.id.textView);
    }
    class ButtonListenter implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button1:
                   k=k+1;
                    textView.setTextSize(k);break;
                case R.id.button2:
                    k=k-1;
                   textView.setTextSize(k);break;
                default:break;
            }
        }
    }
}
