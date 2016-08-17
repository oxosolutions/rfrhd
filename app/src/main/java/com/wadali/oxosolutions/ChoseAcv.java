package com.wadali.oxosolutions;

import com.wadali.handler.BackAction;
import com.wadali.handler.SharedStoregae;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ChoseAcv extends Activity {

	TextView addnewchild, add_digno, addsymptoms, addoutcome, controlgroup;
	// public static String NAME,PASS;
	SharedStoregae SS;

	void back() {
		final Activity a = this;
		TextView back = (TextView) findViewById(R.id.backbtn);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new BackAction(a);
			}
		});
	}

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chose_acv);

		back();
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));
		addnewchild = (TextView) findViewById(R.id.addnewchild);
		add_digno = (TextView) findViewById(R.id.adddignosis);
		addsymptoms = (TextView) findViewById(R.id.addsymptoms);
		addoutcome = (TextView) findViewById(R.id.addoutcome);
		controlgroup = (TextView) findViewById(R.id.controlgroup);
		controlgroup.setOnClickListener(on);

		addnewchild.setOnClickListener(on);
		add_digno.setOnClickListener(on);
		addsymptoms.setOnClickListener(on);
		addoutcome.setOnClickListener(on);
		SS = SharedStoregae.getInstance(getApplicationContext());
		// NAME=SS.GETNAME();
		// PASS=SS.GETPASS();

	}

	OnClickListener on = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == add_digno) {

				Intent i = new Intent(ChoseAcv.this, Adddigno.class);
				startActivity(i);
			} else if (v == addnewchild) {

				Intent i = new Intent(ChoseAcv.this, AddChild.class);
				startActivity(i);
			} else if (v == addsymptoms) {

				Intent i = new Intent(ChoseAcv.this, Addsymptom.class);
				startActivity(i);
			} else if (v == addoutcome) {

				Intent i = new Intent(ChoseAcv.this, AddOutcome.class);
				startActivity(i);
			} else if (v == controlgroup) {

				Intent i = new Intent(ChoseAcv.this, ContrGroup.class);
				startActivity(i);
			}

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_outcome, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

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
		} else if (id == R.id.logout) {

			SharedStoregae s = SharedStoregae
					.getInstance(getApplicationContext());
			s.vibration(false);
			Intent i = new Intent(this, MainActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_CLEAR_TASK);
			startActivity(i);
			finish();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
