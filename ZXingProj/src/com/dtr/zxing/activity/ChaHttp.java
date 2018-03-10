package com.dtr.zxing.activity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;

public class ChaHttp {

	 public static void getlogin2(final Handler handle,final String url){
		 new Thread(new Runnable() {
			 
			 @Override
				public void run() {
					// TODO Auto-generated method stub
					//10.0.2.2:8080
					  //
					try {
						String urls=url+"&msg=cha";
						//String wangluo="http://192.168.200.110:8080/ojbk/Servlet1?name="+URLEncoder.encode(name, "UTF-8")+"&psw="+URLEncoder.encode(pass, "UTF-8");
						URL url=new URL(urls);
						HttpURLConnection conn=(HttpURLConnection)url.openConnection();
						 conn.setConnectTimeout(3000); // 设置超时时间
					        conn.setReadTimeout(3000);
					        conn.setDoInput(true);
					        conn.setRequestMethod("GET"); // 设置获取信息方式
					        conn.setRequestProperty("Charset", "UTF-8"); // 设置接收数据编码格式
						
						int code=conn.getResponseCode();
						System.out.println(code);
						if(code==200){
							InputStream input=conn.getInputStream();
							String str=IOliu.steamtostring(input);  
							System.out.println("校验str"+str);
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
