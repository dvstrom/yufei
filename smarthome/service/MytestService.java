package com.yufei.smarthome.service;

import java.util.ArrayList;
import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.IBinder;

import com.yufei.samrthome.device.*;
import com.google.gson.Gson; 
import com.google.gson.reflect.TypeToken;  
public class MytestService extends Service {

	private List<Light> retlightList=null;
	private List<Tv>  retTvList=null;
	private SQLiteOpenHelper datahelper=null;
	private Devoperate devoperate=null;
	
	public MytestService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		System.out.println("Service oncreate");
		this.datahelper=new DeviceDatabaseHelper(this,"homedevice.db",1);
		Light light1=new Light(0101, 01, 0100, "light-1", "on", 30);
		Light light2=new Light(0102, 01, 0100, "light-2", "on", 40);
		Light light3=new Light(0103, 02, 0100, "light-3", "on", 50);
		Light light4=new Light(0104, 03, 0100, "light-4", "on", 40);
		
		List<Light> lightlist=new ArrayList<Light>();
		lightlist.add(light1);
		lightlist.add(light2);
		lightlist.add(light3);
		lightlist.add(light4);
		
		Tv tv1=new Tv(0201, 01, 0200, "Tv1", "on",66);
		Tv tv2=new Tv(0202, 02, 0200, "Tv2", "on",01);
		List<Tv> tvlist=new ArrayList<Tv>();
		tvlist.add(tv1);
		tvlist.add(tv2);
		
		TableData lighttd = new TableData();  
        lighttd.setTableName("lights");  
        lighttd.setTableData(lightlist);
        
        TableData tvtd = new TableData();  
        tvtd.setTableName("tvs");  
        tvtd.setTableData(tvlist);
        
        List<TableData> tdList = new ArrayList<TableData>();  
        tdList.add(lighttd);  
        tdList.add(tvtd);  
        Gson gson = new Gson();  
        String s = gson.toJson(tdList);
        System.out.println("output s");
        System.out.println(s);
        
        // 将json转为数据-->start  
        List<TableData> tableDatas2 = gson.fromJson(s,  
                new TypeToken<List<TableData>>() {  
                }.getType());  
        for (int i = 0; i < tableDatas2.size(); i++) {  
            TableData entityData = tableDatas2.get(i);  
            String tableName = entityData.getTableName();  
            @SuppressWarnings({ "rawtypes" })
			List tableData = entityData.getTableData();  
            String s2 = gson.toJson(tableData);  
            System.out.println("output s2");
            System.out.println(s2);  
           // System.out.println(entityData.getData());  
            if (tableName.equals("lights")) {  
                System.out.println("lights");  
               retlightList = gson.fromJson(s2,  
                        new TypeToken<List<Light>>() {  
                        }.getType());  
                for (int j = 0; j < retlightList.size(); j++) {  
                	DevtabCursor devtabcursor=new DevtabCursor(this.datahelper.getWritableDatabase());
                	System.out.println("灯光更新输出"+j);
                	System.out.println(retlightList.get(j).getLig_strength());
                	int temp_strength=devtabcursor.findbyid(retlightList.get(j).getDev_id());
                	System.out.println(temp_strength);
                	if (retlightList.get(j).getLig_strength()!=temp_strength){
                		        MytestService.this.devoperate=new Devoperate(
                    			MytestService.this.datahelper.getWritableDatabase());
                		        devoperate.insert(retlightList.get(j).getDev_id(), retlightList.get(j).getDev_roomid(),
                			    retlightList.get(j).getDev_type(),retlightList.get(j).getDev_name(),
                			    retlightList.get(j).getDev_status(),retlightList.get(j).getLig_strength());
                    System.out.println(retlightList.get(j).getDev_name()); 
                	}
                }  
  
            } else if (tableName.equals("tvs")) {  
                System.out.println("tvs");  
                 retTvList = gson.fromJson(s2,  
                        new TypeToken<List<Tv>>() {  
                        }.getType());  
                for (int j = 0; j < retTvList.size(); j++) {
                	DevtabCursor devtabcursor=new DevtabCursor(this.datahelper.getWritableDatabase());
                	System.out.println("TV输出"+j);
                	System.out.println(retTvList.get(j).getChannel());
                	int temp_channel=devtabcursor.findbyid(retTvList.get(j).getDev_id());
                	System.out.println(temp_channel);
                	if (retTvList.get(j).getChannel()!=temp_channel){
                	 MytestService.this.devoperate=new Devoperate(
                 			MytestService.this.datahelper.getWritableDatabase());
                	devoperate.insert(retTvList.get(j).getDev_id(), retTvList.get(j).getDev_roomid(),
                			retTvList.get(j).getDev_type(),retTvList.get(j).getDev_name(),
                			retTvList.get(j).getDev_status(),retTvList.get(j).getChannel());
                    
                    System.out.println(retTvList.get(j));  
                    }  
                }
            }  
        }  
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("Service destroy");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		
        
		return Service.START_CONTINUATION_MASK;
	}

}
