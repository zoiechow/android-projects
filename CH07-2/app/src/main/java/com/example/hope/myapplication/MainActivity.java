package com.example.hope.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker myDate;
    private Button b1;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDate=(DatePicker)findViewById(R.id.myDate);
        b1=(Button)findViewById(R.id.b1);
        t1=(TextView)findViewById(R.id.t1);

        ButtonListener btl=new ButtonListener();
        b1.setOnClickListener(btl);

        myDate.updateDate(2008,7,8);
        //DateListener dtl=new DateListener();

    }
    class DateListener implements DatePicker.OnDateChangedListener{
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        }
    }
    class  ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
           int year=myDate.getYear();
            int month=myDate.getMonth()+1;
            int dayOfMonth=myDate.getDayOfMonth();
           // int minute1= myDate.getCurrentMinute();
       t1.setText("你选择的时间是："+year+"年"+month+"月份"+""+dayOfMonth+"日");
        }
    }
}
