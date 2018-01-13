package com.example.hope.getphonelist;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);

        List<String> contacts=getContactList();
        ArrayAdapter adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,contacts);
        listView.setAdapter(adapter);
    }
     private List<String> getContactList(){
        List<String> contact=new ArrayList<>();
         ContentResolver cr=getContentResolver();//数据解析器
         Cursor   cursor= cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null) ;                           //游标

         if(cursor.moveToFirst()){
             do{
                 String name=cursor.getString(
                         cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                 contact.add(name);
             }while (cursor.moveToNext());
         }  
         cursor.close();
         return contact;
    }

}
