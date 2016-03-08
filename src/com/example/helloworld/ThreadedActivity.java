package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreadedActivity extends ActionBarActivity {

	ImageView iv;
	TextView tv1 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threaded_main);
		
		//get variable from previous activity		
		iv = (ImageView)findViewById(R.id.imgVwProfile);
		Intent intent = getIntent();
		String strMsg = intent.getStringExtra("varStr1");
		tv1 = (TextView)findViewById(R.id.txtVwHello);
		tv1.setText("Welcome to new activity wahai "+strMsg);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.threaded_main, menu);
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
	
	public void fnTakePic(View vw)
	{
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent,0);
				
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						tv1.setText(tv1.getText().toString() + ".. This is your Picture heheh..");
						
						 
					}
				});
				
			}
		};
		
		Thread thr = new Thread(run);
		thr.start();
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		  super.onActivityResult(requestCode, resultCode, data);
	      
	      Bitmap bp = (Bitmap) data.getExtras().get("data");
	      iv.setImageBitmap(bp);
	}
}
