package com.example.listvievedittextcheckbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.listvievedittextcheckbox.ListEditorAdapter.ViewHolder;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button selectAllBtn;
	private Button deselectAllBtn;
	private Button cancelSelectAll;
	
	private ListView listView;
	private ListEditorAdapter mAdapter;

	private List<Map<String, String>> mData = new ArrayList<Map<String,String>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		
		selectAllBtn = (Button) findViewById(R.id.btn_selectAll);
		selectAllBtn.setOnClickListener(this);
		deselectAllBtn = (Button) findViewById(R.id.btn_cancleselectall);
		deselectAllBtn.setOnClickListener(this);
		cancelSelectAll = (Button) findViewById(R.id.btn_cancelAll);
		cancelSelectAll.setOnClickListener(this);
		
		listView = (ListView) findViewById(R.id.list);
		mAdapter = new ListEditorAdapter(this);
		listView.setAdapter(mAdapter);
		for(int i = 0; i < 20; i++) {
			Map<String, String> item = new HashMap<String, String>();
			item.put("list_item_inputvalue", i+"");
			mData.add(item);
		}
		mAdapter.setData(mData);
		
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤
//				ViewHolder holder = (ViewHolder) view.getTag();
//				// 改变CheckBox的状态
//				holder.checkBox.toggle();
//				// 将CheckBox的选中状况记录下来
//				mAdapter.getIsSelected().put(position,holder.checkBox.isChecked());
//				// 调整选定条目
//				if(holder.checkBox.isChecked() == true) {
//					checkNum++;
//				} else {
//					checkNum--;
//				}	
//			}
//		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_selectAll:
			for (int i = 0; i < mData.size(); i++) {
				mAdapter.getIsSelected().put(i, true);
			}
			mAdapter.notifyDataSetChanged();
			break;
		case R.id.btn_cancleselectall:
			// 遍历list的长度，将已选的设为未选，未选的设为已选
			for (int i = 0; i < mData.size(); i++) {
				if (mAdapter.getIsSelected().get(i)) {
					mAdapter.getIsSelected().put(i, false);
				} else {
					mAdapter.getIsSelected().put(i, true);
				}
			}
			mAdapter.notifyDataSetChanged();
			break;
		case R.id.btn_cancelAll:
			for (int i = 0; i < mData.size(); i++) {
				if (mAdapter.getIsSelected().get(i)) {
					mAdapter.getIsSelected().put(i, false);
				}
			}
			mAdapter.notifyDataSetChanged();
			break;
		}
	}

}
