package com.example.hope.endwork2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MoveList extends AppCompatActivity {
    private TextView tv;
    private TextView step1;
    private TextView step2;
    private TextView step3;
    private  ImageView Iv;
    private  String[] strs=new String[]{};
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);


        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");
        String s1=bundle.getString("step1");
        String s2=bundle.getString("step2");
        String s3=bundle.getString("step3");
        Iv=(ImageView) findViewById(R.id.Iv);
        Iv.setImageResource(id);
        tv=(TextView) findViewById(R.id.tv_message);
        tv.setText(message);
        step1=(TextView) findViewById(R.id.step1);
        step2=(TextView) findViewById(R.id.step2);
        step3=(TextView) findViewById(R.id.step3);
        step1.setText(s1);
        step2.setText(s2);
        step3.setText(s3);


//        strs[0]=message;
//        strs[1]=s1;strs[2]=s2;strs[3]=s3;

//        listView = (ListView) findViewById(R.id.lv);
//        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strs));


    }
}
