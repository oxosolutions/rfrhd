package com.wadali.oxosolutions;

import com.wadali.handler.BackAction;
import com.wadali.handler.SharedStoregae;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OuterLogin extends Activity {
	Button submit;
	EditText name, password;
	SharedStoregae SS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_outer_login);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		submit = (Button) findViewById(R.id.loginbutton);
		submit.setOnClickListener(vd);
		name = (EditText) findViewById(R.id.loginname);
		password = (EditText) findViewById(R.id.loginpass);
		SS = SharedStoregae.getInstance(getApplicationContext());
		back();
	}

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

	OnClickListener vd = new OnClickListener() {

		@Override
		public void onClick(View v) {

			String NAME = name.getText().toString();
			String passwords = password.getText().toString();
			String pass = SS.GETPASS();

			if (!NAME.equals("") && passwords.equals(pass)) {

				if (!SS.checkactivated()) {
					Intent i = new Intent(OuterLogin.this, LoginAc.class);
					startActivity(i);
				} else {

					Intent i = new Intent(OuterLogin.this, ChoseAcv.class);
					// SS.PutApplicationID(passwords, NAME);
					// SS.vibration(true);
					i.putExtra("NAME", NAME);
					i.putExtra("PASS", passwords);
					i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(i);
					finish();
					Toast.makeText(getApplicationContext(), "Login Success",
							Toast.LENGTH_SHORT).show();

				}
			} else {
				Toast.makeText(getApplicationContext(),
						"Please Enter valid Data", Toast.LENGTH_SHORT).show();

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
