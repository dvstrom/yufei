package com.yufei.samrthome.device;

import android.os.Parcelable;
import android.os.Parcel; 
/**
 * @author lenovo
 *电视
 */
public class Tv extends Device implements Parcelable {
	private int channel;   ///电视台
	public Tv(int dev_id, int dev_roomid, int dev_type, String dev_name,
			String dev_status,int dev_channel) {
		super(dev_id, dev_roomid, dev_type, dev_name, dev_status);
		// TODO Auto-generated constructor stub
		this.channel=dev_channel;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
