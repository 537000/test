package com.dtr.zxing.activity;

import com.dtr.zxing.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OutActivity extends Activity{
	Context context=null;
	DataApplication dapp;
	EditText  names,xc,yc,zc;
    String admin,psw,name,url,x,y,z;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out);
		context=this;
		dapp=(DataApplication) getApplication(); 
		admin=dapp.getAdmin();
		psw=dapp.getPsw();
		System.out.println("测试out的application:"+admin+psw);
		
		names=(EditText) findViewById(R.id.name1);
		xc=(EditText) findViewById(R.id.xc);
		yc=(EditText) findViewById(R.id.yc);
		zc=(EditText) findViewById(R.id.zc);
		
		Intent in=getIntent();
		url=in.getStringExtra("url");
		
}
	public void click2(View v){
		Intent ins = new Intent(this,CaptureActivity.class);		
//		in.putExtra("url", urlss);
		 startActivity(ins);
	}
	
public void click3(View v){	
	
	name=names.getText().toString();
	x=xc.getText().toString();
	y=yc.getText().toString();
	z=zc.getText().toString();
	
	
	
     url=url+"&name="+name+
    	     "&xc="+x+
    	     "&yc="+y+
    	     "&zc="+z+
    	     "&admin="+admin+
    	     "&psw="+psw;
     System.out.println("最终地址为："+url);
	
     EndHttp.ruku(handsss, url);
	}

Handler handsss	=new Handler(){
	 public void handleMessage(Message mes){
		 
		 String str=(String)mes.obj;
		System.out.println("看一下异常str："+str);
		 int what=mes.what;
		 switch (what) {
			case 3:
				
				Toast.makeText(context, str, Toast.LENGTH_LONG).show();
				
				
				break;

			default:
				break;
		 }
		 }
	 };
	
}
