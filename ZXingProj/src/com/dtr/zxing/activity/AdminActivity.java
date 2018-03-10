package com.dtr.zxing.activity;

import com.dtr.zxing.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends Activity{
	DataApplication dapp;
	TextView name,xc,yc,zc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_out);

		dapp=(DataApplication) getApplication(); 
}
	
	
	
}