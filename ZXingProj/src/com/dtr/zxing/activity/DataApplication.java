package com.dtr.zxing.activity;

import android.app.Application;

public class DataApplication extends Application{
	String admin;
	String names;
	String psw;
	String x;
	String y;
	String z;	
	
	
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
	
	
	@Override  
	public void onCreate() {  
	super.onCreate();  
	//Log.v(TAG, "onCreate");  
	}  
	
}
