package com.dtr.zxing.activity;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class IOliu {
	public static  String steamtostring(InputStream in){
		String str="";
		try {
			ByteArrayOutputStream bytearray=new ByteArrayOutputStream();
			byte[] by=new byte[1024];
			int length=0;
			while((length=in.read(by))!=-1){
				bytearray.write(by, 0, length);
				bytearray.flush();
				
			}
			str = new String(bytearray.toByteArray(),"utf-8");
		} catch (Exception e) {
			 e.printStackTrace();
			 // TODO: handle exception
		}
		 return str;
	}

}
