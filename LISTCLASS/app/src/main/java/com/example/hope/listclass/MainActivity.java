package com.example.hope.listclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView List1;
    private  String[] dataSource={"apple","banana","orange","cherry","mango","watermelon","pear","pineapple",
            "mango","strawberry","mono","worry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List1=(ListView)findViewById(R.id.List1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item,dataSource);
        List1.setAdapter(adapter);
    }
}
