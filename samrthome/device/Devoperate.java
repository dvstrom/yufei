package com.yufei.samrthome.device;

import android.database.sqlite.SQLiteDatabase;

public class Devoperate {
	
	private static final String TABLENAME="device";
	private SQLiteDatabase db=null;
		
	public Devoperate(SQLiteDatabase db) {
		// TODO Auto-generated constructor stub
		this.db=db;
	}
	
	public void insert(int dev_id, int dev_roomid, int dev_type, String dev_name,
			String dev_status,int dev_comments){
		String sql="insert into "+TABLENAME
				+"(dev_id,dev_roomid,dev_type,dev_name,dev_status,dev_comments) VALUES(?,?,?,?,?,?)";
		Object args[]=new Object[]{dev_id,dev_roomid,dev_type,dev_name,dev_status,dev_comments};
		this.db.execSQL(sql, args);
	}
	
	public void delete(int dev_id){
		String sql="delete form"+TABLENAME
				+"where dev_id=?";
		Object args[]=new Object[]{dev_id};
		this.db.execSQL(sql,args);
	}
	
	public void update(int dev_id, int dev_roomid, int dev_type, String dev_name,
			String dev_status,String dev_comments){
		String sql="update"+TABLENAME
				+"SET devi_roomid=?,dev_type=?,dev_name=?,dev_status=?,dev_comments=? where dev_id=?";
		Object args[]=new Object[]{dev_id,dev_roomid,dev_type,dev_name,dev_status,dev_comments};
		this.db.execSQL(sql,args);
	}
}
