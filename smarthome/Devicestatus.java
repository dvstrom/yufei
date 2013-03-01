package com.yufei.smarthome;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;



import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout.LayoutParams;


import com.yufei.samrthome.device.DeviceDatabaseHelper;
import com.yufei.samrthome.device.DevtabCursor;
import com.yufei.smarthome.Panel.PanelClosedEvent;
import com.yufei.smarthome.Panel.PanelOpenedEvent;

public class Devicestatus extends Activity {
	public Panel panel;
	public LinearLayout devicestatuscontainer;
	public GridView devicestatusgridview;
	
	private SQLiteOpenHelper datahelper=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.devicestatus);
		this.setTitle("“设备状态");
		this.datahelper=new DeviceDatabaseHelper(this,"homedevice.db",1);
		this.devicestatusgridview = (GridView) findViewById(R.id.devicestateusgridview);
		this.devicestatuscontainer=(LinearLayout)findViewById(R.id.devicestatuslayoutid);
		panel=new Panel(this,devicestatusgridview,200,LayoutParams.FILL_PARENT);
		
		
		LinearLayout.LayoutParams butparam=new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT);
		Button dengpaoButton=new Button(this);
		dengpaoButton.setLayoutParams(butparam);
		dengpaoButton.setText("房间灯");
		dengpaoButton.setTextColor(Color.RED);
		dengpaoButton.setBackgroundColor(Color.BLUE);
		//加入到Panel里面
		dengpaoButton.setOnClickListener(new dengpaoButtonOnclick());
		//加入到Panel里面
		
		
		Button tvButton=new Button(this);
		tvButton.setLayoutParams(butparam);
		tvButton.setText("TV");
		tvButton.setTextColor(Color.RED);
		tvButton.setBackgroundColor(Color.BLUE);
		//加入到Panel里面
		tvButton.setOnClickListener(new tvOnclick());
		
		
		panel.fillPanelContainer(dengpaoButton);
		panel.fillPanelContainer(tvButton);
		devicestatuscontainer.addView(panel);//加入Panel控件
		panel.setPanelClosedEvent(panelClosedEvent);
		panel.setPanelOpenedEvent(panelOpenedEvent);
						
	}
	private class dengpaoButtonOnclick implements OnClickListener{

		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 * 利用stringtokenizer将CURSOR中的字符串分割
		 */
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//往GridView填充测试数据
			DevtabCursor devtabcursor=new DevtabCursor(datahelper.getWritableDatabase());
        	System.out.println("灯光页面");
        	 List<String> temp_light=devtabcursor.findType(64);
              	 
        	 for (int j=0;j<temp_light.size();j++){
        		 StringTokenizer st=new StringTokenizer(temp_light.get(j), " ");
        		 System.out.println(st.nextToken());
        		 System.out.println(st.nextToken());
        		 System.out.println(st.nextToken());
        		 System.out.println(st.nextToken());
        		 System.out.println(st.nextToken());
        		 System.out.println(st.nextToken());
        	 }
        	System.out.println(temp_light);
			devicestatusgridview.removeAllViewsInLayout();
			ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
			for (int i = 0; i < 10; i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("ItemImage", R.drawable.light_one);
				map.put("ItemText", "NO." + String.valueOf(i));
				lstImageItem.add(map);
			}

			SimpleAdapter saImageItems = new SimpleAdapter( Devicestatus.this, 
					lstImageItem,
					R.layout.item1, 
					new String[] { "ItemImage", "ItemText" },
					new int[] { R.id.ItemImage, R.id.ItemText });
			devicestatusgridview.setAdapter(saImageItems);
			devicestatusgridview.setOnItemClickListener(new ItemClickListener());
		}
		
	}
	private class tvOnclick implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			devicestatusgridview.removeAllViewsInLayout();
			ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
			for (int i = 0; i < 3; i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("ItemImage", R.drawable.dianshi);
				map.put("ItemText", "NO." + String.valueOf(i));
				lstImageItem.add(map);
			}

			SimpleAdapter saImageItems = new SimpleAdapter( Devicestatus.this, 
					lstImageItem,
					R.layout.item1, 
					new String[] { "ItemImage", "ItemText" },
					new int[] { R.id.ItemImage, R.id.ItemText });
			devicestatusgridview.setAdapter(saImageItems);
			//devicestatusgridview.setOnItemClickListener(new ItemClickListener());
		}
		
	}
	

	PanelClosedEvent panelClosedEvent =new PanelClosedEvent(){

		@Override
		public void onPanelClosed(View panel) {
			Log.i("panelClosedEvent","panelClosedEvent");
		}
		
	};
	
	PanelOpenedEvent panelOpenedEvent =new PanelOpenedEvent(){

		@Override
		public void onPanelOpened(View panel) {
			Log.i("panelOpenedEvent","panelOpenedEvent");
		}
		
	};
	
	class ItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3) {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> item = (HashMap<String, Object>) arg0
					.getItemAtPosition(arg2);
			setTitle((String) item.get("ItemText"));
		}

	}
}
		
	  
	
	/*PanelClosedEvent panelClosedEvent =new PanelClosedEvent(){

		@Override
		public void onPanelClosed(View panel) {
			Log.e("panelClosedEvent","panelClosedEvent");
		}
		
	};
	
	PanelOpenedEvent panelOpenedEvent =new PanelOpenedEvent(){

		@Override
		public void onPanelOpened(View panel) {
			Log.e("panelOpenedEvent","panelOpenedEvent");
		}
		
	};

	
}*/
