package com.dtr.zxing.activity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



import android.os.Handler;
import android.os.Message;

public class LoginHttp {
	 

	 public static void getlogin(final Handler handle,final String admin,final String pass ){
		 new Thread(new Runnable() {
			 
			 @Override
				public void run() {
					// TODO Auto-generated method stub
					//10.0.2.2:8080
					  //
					try {
						String wangluo="http://192.168.253.2:8080/ojbk/Servlet1?admin="+URLEncoder.encode(admin, "UTF-8")+"&psw="+URLEncoder.encode(pass, "UTF-8");
						URL url=new URL(wangluo);
						HttpURLConnection con=(HttpURLConnection)url.openConnection();
						con.setConnectTimeout(1000*5);
						con.setRequestMethod("GET");
						
						int code=con.getResponseCode();
						System.out.println(code);
						if(code==200){
							InputStream input=con.getInputStream();
							String str=IOliu.steamtostring(input);
							Message meg=new Message();
							meg.what = 1;
							meg.obj=str;
							handle.sendMessage(meg);
							
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}).start();
		 }
		

}
