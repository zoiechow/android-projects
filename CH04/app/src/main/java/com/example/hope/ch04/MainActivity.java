package com.example.hope.ch04;

import android.os.BaseBundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    private CheckBox tc;
    private CheckBox sl;
    private  CheckBox hs;
    private  CheckBox dg;

    private  Button submit;
    private Button allYes;
    private  Button  allNo;
    private Button  reverse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tc=(CheckBox)findViewById(R.id.tc);
        sl=(CheckBox)findViewById(R.id.sl);
        hs=(CheckBox)findViewById(R.id.hs);
        dg=(CheckBox)findViewById(R.id.dg);

        allYes=(Button)findViewById(R.id.allYes) ;
        allNo=(Button)findViewById(R.id.allNo);
/*
        CheckBoxListener Listener=new CheckBoxListener();
        watermelonBox.setOnCheckedChangeListener(Listener);
        mangoBox.setOnCheckedChangeListener(Listener);
        pomeloBox.setOnCheckedChangeListener(Listener);
*/
       /* BoxClickListener boxListener=new BoxClickListener();
        tc.setOnClickListener(boxListener);
        sl.setOnClickListener(boxListener);
        hs.setOnClickListener(boxListener);
        dg.setOnClickListener(boxListener);*/

        ButtonListener buttonListener=new ButtonListener();
        allYes.setOnClickListener(buttonListener);
        allNo.setOnClickListener(buttonListener);
        reverse.setOnClickListener(buttonListener);
        submit.setOnClickListener(buttonListener);


    }

    class  ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.allYes){
            tc.setChecked(true);
            sl.setChecked(true);
            hs.setChecked(true);
            dg.setChecked(true);
            }
            else {
                tc.setChecked(false);
                sl.setChecked(false);
                hs.setChecked(false);
                dg.setChecked(false);}
        }
    }
    //整个复选框的LISTENER
  /*  class BoxClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            CheckBox box=(CheckBox)v;
           // System.out.println("你点击的复选框ID 是" + v.getId());

            if(v.getId()==R.id.watermelon){
                System.out.println("你点击了西瓜");}
            else if(v.getId()==R.id.mango){
                System.out.println("你点击了芒果");}
            else if(v.getId()==R.id.pomelo){
                System.out.println("你点击了柚子");}

            if(box.isChecked()){
                System.out.println("你被选中了");}
                else{
                    System.out.println("你被取消选中了");
                }

        }
    }

            //是单个复选框的LISTENER
   /* class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
            //System.out.println("你点击了复选框");
            if(compoundButton.getId()==R.id.watermelon)
                System.out.println("你点击了西瓜");
            else if(compoundButton.getId()==R.id.mango)
                System.out.println("你点击了芒果");
            else if(compoundButton.getId()==R.id.pomelo)
                System.out.println("你点击了柚子");

            if(b){
                System.out.println("被选中了");
            }
            else{
                System.out.println("被取消选中了");
            }
        }
    }*/


}
