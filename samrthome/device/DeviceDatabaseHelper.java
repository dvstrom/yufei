package com.yufei.samrthome.device;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DeviceDatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASENAME="homedevice.db";
	private static final int DATABASEVERSION=1;
	private static final String TABLENAME="device";

	public DeviceDatabaseHelper(Context context){
		super(context,DATABASENAME,null,DATABASEVERSION);
	}

	public DeviceDatabaseHelper(Context context, String name,
			 int version) {
		super(context, name, null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="CREATE TABLE IF NOT EXISTS " + TABLENAME +"(" +
					"dev_id    int   not null," +
					"dev_roomid integer  not null," +
					"dev_type   integer   not null,"  +
					"dev_name   string    not  null," +
					"dev_status string     not  null,"+
					"dev_comments integer   not null)";
		db.execSQL(sql);
					
 	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		super.onOpen(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql="DROP TABLE IF EXISTS" + TABLENAME;
		db.execSQL(sql);
		this.onCreate(db);
	}
	
	
	
}
