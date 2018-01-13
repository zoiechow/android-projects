package com.example.hope.simple_cursor_adapterlist;

import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);
        //定义数据
        Cursor cursor=getContentResolver().query(Contacts.People.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);//系统自动管理游标
        //定义ADAPTER
        ListAdapter listAdapter=new SimpleCursorAdapter(
                this,android.R.layout.simple_list_item_1,cursor,
                new String[]{Contacts.People.DISPLAY_NAME},new int[]{android.R.id.text1});
        //载入Adapter
        listView.setAdapter(listAdapter);

    }


}
