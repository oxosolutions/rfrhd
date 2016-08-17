package com.wadali.oxosolutions;

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

import com.wadali.handler.BackAction;
import com.wadali.handler.SharedStoregae;

public class LoginAc extends Activity {
	Button submit;
	EditText name, password;
	SharedStoregae SS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
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
				String pass = SS.getactiivation();
				if (!NAME.equals("") && passwords.equals(pass)) {
					Intent i = new Intent(LoginAc.this, ChoseAcv.class);
//					SS.PutApplicationID(passwords, NAME);
					SS.activated(true);
					SS.vibration(true);
					i.putExtra("NAME", NAME);
					i.putExtra("PASS", passwords);
					i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					startActivity(i);
					finish();
					Toast.makeText(getApplicationContext(), "Activated",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"Please Enter valid Actication Code",
							Toast.LENGTH_SHORT).show();
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

			return true;
		} else if (id == R.id.contact) {

			return true;
		} else if (id == R.id.help) {

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
