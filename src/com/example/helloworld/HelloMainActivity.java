package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloMainActivity extends ActionBarActivity {

	private EditText edtText1,edtAge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello_main, menu);
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
	
	public void fnGreet(View vw)
	{
		edtText1 = (EditText) findViewById(R.id.txtFldName) ;
		TextView tv1 = (TextView)findViewById(R.id.txtVwHello1);
		
		edtAge = (EditText) findViewById(R.id.edtAge);
		int intYear = 2016 - Integer.parseInt(edtAge.getText().toString());
		tv1.setText("Hello and welcome.."+edtText1.getText()+".. You are born on "+ String.valueOf(intYear));
		
	}
	
	public void fnInvokeCalcActivity(View vw)
	{
		Intent intent = new Intent(this, CalcuActivity.class);
		String strMsg = ((EditText) findViewById(R.id.txtFldName)).getText().toString() ;
		intent.putExtra("varStr1", strMsg);
		startActivity(intent);
		
	}
	
	public void fnInvokeCam(View vw)
	{
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent,0);
		
	}
	
	public void fnThreadActivity(View vw)
	{
		Intent intent = new Intent(this, ThreadedActivity.class);
		String strMsg = ((EditText) findViewById(R.id.txtFldName)).getText().toString() ;
		intent.putExtra("varStr1", strMsg);
		startActivity(intent);
		
	}
	
}
