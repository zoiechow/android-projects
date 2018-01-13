package com.example.hope.endwork2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private ImageView ivDeleteText;
    private EditText etSearch;
    private ListView Lv;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lv=(ListView)findViewById(R.id.listview) ;
        ivDeleteText = (ImageView) findViewById(R.id.ivDeleteText);
        etSearch = (EditText) findViewById(R.id.etSearch);




        final String[] name = new String[]{"曲奇饼干", "家常烙饼", "蛋糕"};
        final String[] info=new String[]{"口感酥脆香味浓郁的葡萄干麦片曲奇",
                "韧劲十足，越嚼越香的家常烙饼",
                "浓郁香甜，美味无比"};
        final String[] message = new String[]{"口感酥脆香味浓郁的葡萄干麦片曲奇， " +
                "大大一片的厚曲奇满满麦香，还可以吃到葡萄干的酸甜软糯，搭配一杯咖啡或热可可，这样的下午茶太温暖~",
                "韧劲十足，越嚼越香的家常烙饼，层次多多，外酥里嫩，配上小咸菜和小米粥就是一顿完美早餐~",
                "谭咏麟，1950年8月23日出生于香港，中国香港男歌手、音乐人、演员。"};
        final String[] step1=new String[]{"准备食材，烤箱预热到190度，烤盘铺好烘焙纸。","gh","jj"};
        final String[] step2=new String[]{"在搅拌碗里加入黄油和两种砂糖，搅拌均匀后加入鸡蛋和香草精继续搅拌直到均匀。" +
                "把面粉、小苏打和盐筛入蛋液中搅拌看不到干面粉,然后加入麦片和葡萄干搅拌均匀。","oo","oo"};
        final String[] step3=new String[]{"用冰激凌把面糊挖成小圆球放到提前铺好烘焙纸的烤盘上，每个曲奇之间留出足够的空间。" +
                "然后用手压扁一点。曲奇送入烤箱190度烤10-12分钟，或者曲奇的边缘微微发黄即可。","pp","pp"};
        final int[] photo = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3};

        List<Map<String, Object>> data = new ArrayList();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("photo", R.drawable.p1);
        map1.put("name", name[0]);
        map1.put("info", info[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("photo", R.drawable.p2);
        map2.put("name", name[1]);
        map2.put("info", info[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("photo", R.drawable.p3);
        map3.put("name", name[2]);
        map3.put("info", info[2]);
        data.add(map3);

        final SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.item, new String[]{"photo", "name","info"},
                new int[]{R.id.iv, R.id.tv_name,R.id.tv_info});

        Lv.setAdapter(adapter);

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View ar1, int arg2, long arg3) {
                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("info",info[arg2]);
                bundle.putString("message", message[arg2]);
                bundle.putString("step1", step1[arg2]);
                bundle.putString("step2", step2[arg2]);
                bundle.putString("step3", step3[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this, MoveList.class);
                Log.i("message", message[arg2]);
                Log.i("step1,",step1[arg2]);
                Log.i("step2,",step2[arg2]);
                Log.i("step3,",step3[arg2]);
                startActivity(intent);
                finish();

            }
        });

        ivDeleteText.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                etSearch.setText("");
            }
        });


        etSearch.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                String aa = arg0.toString();
                Pattern p = Pattern.compile(aa);

                // TODO Auto-generated method stub

            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    ivDeleteText.setVisibility(View.GONE);
                } else {
                    ivDeleteText.setVisibility(View.VISIBLE);
                    //myhandler.post(eChanged);
                }
            }
        });
    }
}
