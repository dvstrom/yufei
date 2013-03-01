package com.yufei.samrthome.device;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DevtabCursor {

	private static final String TABLENAME="device";
	private SQLiteDatabase db=null;

	public DevtabCursor(SQLiteDatabase db) {
		
		this.db=db;
	}

	public List<String> findType(int type){
		List<String> all=new ArrayList<String>();
		
		Cursor result=this.db.rawQuery("select * from device where dev_type=?", new String[]{String.valueOf(type)});
		for(result.moveToFirst();!result.isAfterLast();result.moveToNext()){
			all.add(result.getInt(0)+" "+result.getInt(1)+" "+result.getInt(2)+" "
					+result.getString(3)+" "+result.getString(4)+" "+result.getInt(5));
		}
		result.close();
		System.out.println(all);
		this.db.close();
		return all;
	}
	
	public int findbyid(int id){
		System.out.println(id);
		int dev_comments=0;
	
		Cursor result=this.db.rawQuery("select * from device where dev_id=?", new String[]{String.valueOf(id)});

		if (result.moveToFirst()){
		System.out.println("数据库的输出强度:" + result.getInt(5));
		}
		if (result.getCount()==1){
			dev_comments=result.getInt(5);
		}
		else{
			System.out.println("database count is wrong");
		}
		result.close();
		this.db.close();
		return dev_comments;
	}
	
}
