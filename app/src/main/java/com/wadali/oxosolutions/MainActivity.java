package com.wadali.oxosolutions;

import com.wadali.handler.DatabaseHelper;
import com.wadali.handler.SharedStoregae;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView login, reg, update;

	SharedStoregae SS;
	DatabaseHelper heler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// Color.parseColor("#168DC5"));
		login = (TextView) findViewById(R.id.login);
		reg = (TextView) findViewById(R.id.registration);
		reg.setOnClickListener(onclick);
		login.setOnClickListener(onclick);

		heler = new DatabaseHelper(getApplicationContext());

		SS = SharedStoregae.getInstance(getApplicationContext());

		if (SS.vibrationcheck()) {
			Intent i = new Intent(this, ChoseAcv.class);
			startActivity(i);
			finish();
		}
		if (!SS.FirstrunCheck()) {
			SS.FirstRun();
			heler.copyDataBase();
		}
		
	
		// update=(TextView)findViewById(R.id.);

	}

	OnClickListener onclick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (v == login) {
				Intent i = new Intent(MainActivity.this, OuterLogin.class);
				startActivity(i);
			} else if (v == reg) {
				Intent i = new Intent(MainActivity.this, RegAc.class);
				startActivity(i);

			} else if (v == update) {

			}

		}
	};

	public void sendSMSsS(String phoneNo, String msg) {
		try {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phoneNo, null, msg, null, null);
			Toast.makeText(getApplicationContext(), "Message Sent",
					Toast.LENGTH_LONG).show();
		} catch (Exception ex) {
			Toast.makeText(getApplicationContext(), ex.getMessage().toString(),
					Toast.LENGTH_LONG).show();
			ex.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_child, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			Intent i = new Intent(getApplicationContext(), Loader.class);
			i.putExtra("url", "aboutus.html");
			startActivity(i);
			return true;
		} else if (id == R.id.contact) {
			Intent i = new Intent(getApplicationContext(), Loader.class);
			i.putExtra("url", "contactus.html");
			startActivity(i);
			return true;
		} else if (id == R.id.help) {
			Intent i = new Intent(getApplicationContext(), Loader.class);
			i.putExtra("url", "help.html");
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
