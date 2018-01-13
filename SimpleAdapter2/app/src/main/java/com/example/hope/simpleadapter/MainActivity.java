package com.example.hope.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        SimpleAdapter adapter=new SimpleAdapter(this,getData(),R.layout.vlist,
                new String[]{"title","price","info","img"},
                new int[]{R.id.title,R.id.price,R.id.info,R.id.img});

    }

    private List<Map<String,Object>>getData(){
        List<Map<String,Object>> List=new ArrayList<Map<String,Object>>();

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("title","香蕉");
        map.put("info","哈哈哈哈哈哈哈");
        map.put("price","哈哈哈");
        map.put("img",R.drawable.f1);
        List.add(map);

         map=new HashMap<String,Object>();
        map.put("title","香蕉");
        map.put("info","哈哈哈哈哈哈哈");
        map.put("price","哈哈哈");
        map.put("img",R.drawable.f2);
        List.add(map);

        map=new HashMap<String,Object>();
        map.put("title","香蕉");
        map.put("info","哈哈哈哈哈哈哈");
        map.put("price","哈哈哈");
        map.put("img",R.drawable.f1);
        List.add(map);

        map=new HashMap<String,Object>();
        map.put("title","香蕉");
        map.put("info","哈哈哈哈哈哈哈");
        map.put("price","哈哈哈");
        map.put("img",R.drawable.f1);
        List.add(map);

        return  List;
    }

}
