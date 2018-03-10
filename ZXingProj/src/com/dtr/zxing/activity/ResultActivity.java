package com.dtr.zxing.activity;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.dtr.zxing.R;
import com.dtr.zxing.decode.DecodeThread;

public class ResultActivity extends Activity {
	 Context context=null;
	private ImageView mResultImage;
	private TextView mResultText , tvname,weizhi;
	private Button bt2,bt3;
	String urlss;
	static String str ,names="",xc,yc,zc;
	DataApplication dapp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		context=this;
		
		dapp=(DataApplication) getApplication(); 
		
		Bundle extras = getIntent().getExtras();

		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		mResultImage = (ImageView) findViewById(R.id.result_image);
		mResultText = (TextView) findViewById(R.id.result_text);
		tvname=(TextView) findViewById(R.id.names);
		weizhi=(TextView) findViewById(R.id.weizhi);
		if (null != extras) {
			int width = extras.getInt("width");
			int height = extras.getInt("height");

			LayoutParams lps = new LayoutParams(width, height);
			lps.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
			lps.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
			lps.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
			
			mResultImage.setLayoutParams(lps);

			String result = extras.getString("result");
			urlss=result;
			mResultText.setText(result);

			Bitmap barcode = null;
			byte[] compressedBitmap = extras.getByteArray(DecodeThread.BARCODE_BITMAP);
			if (compressedBitmap != null) {
				barcode = BitmapFactory.decodeByteArray(compressedBitmap, 0, compressedBitmap.length, null);
				// Mutable copy:
				barcode = barcode.copy(Bitmap.Config.RGB_565, true);
			}

			mResultImage.setImageBitmap(barcode);
		}
	}

	
	public void click1(View v){		
		ChaHttp.getlogin2(handsss, urlss);
//		Intent in = new Intent(this,UrlActivity.class);		
//		/*Bundle bundle = new Bundle();  
//        bundle.putString("names",names ); 
//        bundle.putString("xc", xc); 
//        bundle.putString("yc",yc ); 
//        bundle.putString("zc", zc); 
//        
//          
//        in.putExtras(bundle);  */
		 System.out.println("测试打印"+names);     
//		  startActivity(in);		
	}
	//出库
	public void click2(View v){		
	EndHttp.end(handsss, urlss);
	}
	//入库
	public void click3(View v){	
		
		Intent in = new Intent(this,OutActivity.class);		
		in.putExtra("url", urlss);
		 startActivity(in);
	}
	
	 Handler handsss	=new Handler(){
		 public void handleMessage(Message mes){
			 
			  str=(String)mes.obj;
			  System.out.println("信息传递："+str);
			 int what=mes.what;
			 switch (what) {
			    case 2:
			    	try {
			    		Toast.makeText(context, "出仓成功", Toast.LENGTH_LONG).show();			    		
			    		tvname.setText("物品名：暂无信息");
				         weizhi.setText("物品位置：暂无信息");
				         bt2.setVisibility(View.GONE);
				         bt3.setVisibility(View.VISIBLE);
					} catch (Exception e) {
						e.printStackTrace();
					}
			    case 3:try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				case 1:			
				JSONObject json;
				try {
					if(str==null||str.equalsIgnoreCase("")){
					
						tvname.setText("物品名：暂无信息");
				         weizhi.setText("物品位置：暂无信息");
				         bt3.setVisibility(View.VISIBLE);
			     	
					}else{
						json = new JSONObject(str);
						 names=(String) json.get("names");
						 xc=(String) json.get("xc");
				         yc=(String) json.get("yc");
				         zc=(String) json.get("zc");
				         if(names.equalsIgnoreCase("")||names==null){
				        	     tvname.setText("物品名：暂无信息");
						         weizhi.setText("物品位置：暂无信息");
						         bt3.setVisibility(View.VISIBLE);
				         }else{
				        	 tvname.setText("物品名："+names);
					         weizhi.setText("物品位置："+xc+"-"+yc+"-"+zc);
					         bt2.setVisibility(View.VISIBLE);
				         }
				        
				         System.out.println("全局变量是否ok:   "+dapp.getNames());
				 	
				         System.out.println( "阿贾克："+xc);
						
						
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			        
					
					break;

				default:
					break;
			 }
			 }
		 };
	
}
