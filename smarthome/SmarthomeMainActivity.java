package com.yufei.smarthome;





import java.util.ArrayList;
import java.util.HashMap;
import com.yufei.smarthome.R.drawable;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import com.yufei.smarthome.service.*;
public class SmarthomeMainActivity extends Activity {
	public GridView gridview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("与非智能家居控制系统客户端-主菜单");
		setContentView(R.layout.activity_smarthome_main);
		this.gridview = (GridView) findViewById(R.id.gridview);
		//gridview.setBackgroundResource(R.drawable.main_bg);
		
		ArrayList<HashMap<String, Object>> alFuctionItems = 
	        	new ArrayList<HashMap<String, Object>>();
		
		/* HashMap<String, Object> map0 = new HashMap<String, Object>();
	        map0.put("Image", null);
	        map0.put("Text", null);
	        alFuctionItems.add(map0);
	      */  
		HashMap<String, Object> map0 = new HashMap<String, Object>();
		map0.put("Image", R.drawable.changjing);
		map0.put("Text", "场景设置");
		alFuctionItems.add(map0);
		
		HashMap<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Image", R.drawable.mensuo);
		map1.put("Text", "我的房间");
		
		alFuctionItems.add(map1);

		HashMap<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Image", R.drawable.shezhi);
		map2.put("Text", "系统设置");
		alFuctionItems.add(map2);

		HashMap<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Image", R.drawable.shebei);
		map3.put("Text", "设备控制");
		alFuctionItems.add(map3);

		HashMap<String, Object> map4 = new HashMap<String, Object>();
		map4.put("Image", R.drawable.bufang);
		map4.put("Text", "安防设置");
		alFuctionItems.add(map4);

		HashMap<String, Object> map5 = new HashMap<String, Object>();
		map5.put("Image", R.drawable.shebeizhuangtai);
		map5.put("Text", "设备状态");
		alFuctionItems.add(map5);

		/*HashMap<String, Object> map6 = new HashMap<String, Object>();
		map6.put("Image", null);
		map6.put("Text", null);
		alFuctionItems.add(map6);

		HashMap<String, Object> map7 = new HashMap<String, Object>();
		map7.put("Image", R.drawable.shezhi);
		map7.put("Text", "系统设置");
		alFuctionItems.add(map7);
		
		HashMap<String, Object> map8 = new HashMap<String, Object>();
		map8.put("Image", null);
		map8.put("Text", null);
		alFuctionItems.add(map8);
		
		HashMap<String, Object> map9 = new HashMap<String, Object>();
		map9.put("Image", R.drawable.changjing);
		map9.put("Text", "场景设置");
		alFuctionItems.add(map9);
		
		HashMap<String, Object> map10 = new HashMap<String, Object>();
		map10.put("Image", null);
		map10.put("Text", null);
		alFuctionItems.add(map10);
		
		HashMap<String, Object> map11 = new HashMap<String, Object>();
		map11.put("Image", R.drawable.bufang);
		map11.put("Text", "安防设置");
		alFuctionItems.add(map11);
		*/
		SimpleAdapter saImageItems = new SimpleAdapter(this, alFuctionItems,
				R.layout.function_item, new String[] { "Image", "Text" },
				new int[] { R.id.ItemImage, R.id.ItemText });

		gridview.setAdapter(saImageItems);
		gridview.setOnItemClickListener(new ItemClickListener());
		SmarthomeMainActivity.this.startService(new Intent(
				SmarthomeMainActivity.this,
				com.yufei.smarthome.service.MytestService.class));
	
	}

	  class ItemClickListener implements OnItemClickListener {
			public void onItemClick
			(AdapterView<?> arg0,View arg1,int arg2,long arg3) 
			{
				Intent intent;
				switch (arg2) {
				/*case 1:
	   				intent = new Intent(SmarthomeMainActivity.this, Map_Slipy.class);
	                startActivity(intent);					
					break;
				case 3:
	   				intent = new Intent(SmarthomeMainActivity.this, Electronic_Control.class);
	                startActivity(intent);					
					break;*/
				case 5:
					intent = new Intent(SmarthomeMainActivity.this,  Devicestatus.class);
	                startActivity(intent);					
					break;
				/*case 7:
	   				intent = new Intent(SmarthomeMainActivity.this, System_Set.class);
	                startActivity(intent);					
					break;
				case 9:
	   				intent = new Intent(SmarthomeMainActivity.this, System_Set.class);
	                startActivity(intent);					
					break;
				case 11:
	   				intent = new Intent(SmarthomeMainActivity.this, System_Set.class);
	                startActivity(intent);					
					break;*/
				default:
					break;
				}		
			}
		}
}
