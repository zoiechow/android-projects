package com.example.hope.ch07class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePicker myTime;
    private TextView t1;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.t1);

        b1=(Button)findViewById(R.id.b1);
        ButtonListener btl=new ButtonListener();
        b1.setOnClickListener(btl);

        //myTime.setIs24HourView(true);
        myTime=(TimePicker)findViewById(R.id.myTime);
        //TimeListener timeListener=new TimeListener();
        //myTime.setOnTimeChangedListener(timeListener);

        myTime.setCurrentHour(8);
        myTime.setCurrentMinute(18);
    }
    class TimeListener implements  TimePicker.OnTimeChangedListener{
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            //System.out.println("小时："+hourOfDay+"  "+"分钟:"+minute);
            t1.setText("你选择的时间是："+hourOfDay+"小时"+""+minute+"分钟");
        }
    }
    class  ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int hour=myTime.getCurrentHour();
            int minute1= myTime.getCurrentMinute();
            t1.setText("你选择的时间是："+hour+"小时"+""+minute1+"分钟");
        }
    }
}

