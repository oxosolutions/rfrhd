package com.wadali.oxosolutions;

import com.wadali.handler.BackAction;

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

public class RegAc extends Activity {

	TextView regasteacher, regasdocto, regasparent;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		ActionBar abs = getActionBar();
		back();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		regasdocto = (TextView) findViewById(R.id.regasdoctor);
		regasparent = (TextView) findViewById(R.id.regasparent);
		regasteacher = (TextView) findViewById(R.id.regasteacher);
		regasdocto.setOnClickListener(onclick);
		regasparent.setOnClickListener(onclick);
		regasteacher.setOnClickListener(onclick);

	}

	OnClickListener onclick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (v == regasdocto) {
				Intent i = new Intent(RegAc.this, RegByDoctor.class);
				startActivity(i);

			} else if (v == regasparent) {
				Intent i = new Intent(RegAc.this, RegByParnt.class);
				startActivity(i);

			} else if (v == regasteacher) {
				Intent i = new Intent(RegAc.this, RegByTeachr.class);
				startActivity(i);

			}

		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.add_child, menu);

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
		}
		return super.onOptionsItemSelected(item);
	}
}
