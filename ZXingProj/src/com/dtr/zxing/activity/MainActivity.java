package com.dtr.zxing.activity;
import com.dtr.zxing.R;

import android.text.TextUtils;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	DataApplication dapp;

	   EditText zhanghao=null;
	   EditText psw=null;
	   CheckBox saves=null;
	   Button bton=null;
	   Context context=null;
	   //判断是否登录成功 如果为true的话那么就跳转
	  Boolean bln=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dapp=(DataApplication) getApplication(); 
		context=this;
		psw=(EditText) findViewById(R.id.mima);
		zhanghao = (EditText) findViewById(R.id.zhanghao);
		
		bton= (Button) findViewById(R.id.denglu);
		bton.setOnClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.denglu:
			cha();
			if(bln){
			Intent in = new Intent(this,CaptureActivity.class);		
			startActivity(in);
			}
			break;
		default:
			break;
		}
	}
	
	String name = null;
	String pass = null;
	boolean isdagou = false;
	private void cha(){
		name=zhanghao.getText().toString().trim();
		pass=psw.getText().toString().trim();
		 //ischecked判断是否复选
		// isdagou=saves.isChecked();
		 if(TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)){
			 Toast.makeText(this,"用户名密码不能为空!", Toast.LENGTH_LONG).show();
			 return;
		 }
		 LoginHttp.getlogin(handsss, name, pass);
		 
		
	}
	 Handler handsss	=new Handler(){
		 public void handleMessage(Message mes){
			 
			 String str=(String)mes.obj;
			 int what=mes.what;
			 switch (what) {
				case 1:
					if(str.equalsIgnoreCase("登录成功")){
						bln=true;
						dapp.setAdmin(zhanghao.getText().toString());
						dapp.setPsw(psw.getText().toString());
					}
					Toast.makeText(context, str, Toast.LENGTH_LONG).show();
					
					
					break;

				default:
					break;
			 }
			 }
		 };
	 }
			
	
		 
	 
	
	
	

