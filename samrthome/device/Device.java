package com.yufei.samrthome.device;

/**
 * @author lenovo
 *所有设备的基类
 */
public class Device {
	
	private int dev_id; 
	private int dev_roomid;
	private int dev_type;
	private String dev_name;
	private String dev_status;
	public Device(int dev_id, int dev_roomid, int dev_type, String dev_name,
			String dev_status) {
		this.dev_id = dev_id;
		this.dev_roomid = dev_roomid;
		this.dev_type = dev_type;
		this.dev_name = dev_name;
		this.dev_status = dev_status;
	}
	public int getDev_id() {
		return dev_id;
	}
	public void setDev_id(int dev_id) {
		this.dev_id = dev_id;
	}
	public int getDev_roomid() {
		return dev_roomid;
	}
	public void setDev_roomid(int dev_roomid) {
		this.dev_roomid = dev_roomid;
	}
	public int getDev_type() {
		return dev_type;
	}
	public void setDev_type(int dev_type) {
		this.dev_type = dev_type;
	}
	public String getDev_name() {
		return dev_name;
	}
	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}
	public String getDev_status() {
		return dev_status;
	}
	public void setDev_status(String dev_status) {
		this.dev_status = dev_status;
	}


}
