package com.example.hope.ch08class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private  ProgressBar firstProgress;
    private Button b1;
    private  Button b2;
    private Button b3;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         firstProgress=(ProgressBar)findViewById(R.id.firstProgress);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        ButtonListener btl=new ButtonListener();
        b1.setOnClickListener(btl);
        b2.setOnClickListener(btl);
        ButtonListenerAuto autoBtl=new ButtonListenerAuto();
        b3.setOnClickListener(autoBtl);

        seekBar=(SeekBar)findViewById(R.id.seekBar);
        SeekBarChangeListener scl=new SeekBarChangeListener();
        seekBar.setOnSeekBarChangeListener(scl);
    }
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.b1){
                firstProgress.incrementProgressBy(5);
            }else{
                firstProgress.incrementSecondaryProgressBy(5 );
            }
        }
    }
    class ButtonListenerAuto implements View.OnClickListener{
        @Override
        public void onClick(View v) {

        }
    }
    class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener{
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            System.out.println("点击的seekBar的ID是"+seekBar.getId()+"当前进度"+i+"是否来自用户"+b);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            System.out.println("触发了onStartTrackingTouch事件，ID是"+seekBar.getId());
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            System.out.println("触发了onStopTrackingTouch事件，ID是"+seekBar.getId());
        }
    }
}
