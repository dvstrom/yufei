package com.yufei.samrthome.device;

/**
 * @author lenovo
 *lightµÄÀà
 */

public class Light extends Device {
	private int lig_strength;

	public Light(int dev_id, int dev_roomid, int dev_type, String dev_name,
			String dev_status,int lig_strength) {
		super(dev_id, dev_roomid, dev_type, dev_name, dev_status);
		// TODO Auto-generated constructor stub
		this.lig_strength=lig_strength;
	}

	public int getLig_strength() {
		return lig_strength;
	}

	public void setLig_strength(int lig_strength) {
		this.lig_strength = lig_strength;
	}
	
	
}
