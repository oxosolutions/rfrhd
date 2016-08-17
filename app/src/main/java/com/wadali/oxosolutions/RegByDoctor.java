package com.wadali.oxosolutions;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.wadali.handler.LocalClass;
import com.wadali.handler.SharedStoregae;
import com.wadali.handler.StaticVariables;

public class RegByDoctor extends Activity {

	// RadioButton radio1, radio2;
	EditText mobilenumber, username, password, retypepass, fname, lastname;
	TextView textView5;
	Button button1;

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

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_by_doctor);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		// radio1 = (RadioButton) findViewById(R.id.radioButton1);
		// radio1.setOnClickListener(radioclick);
		// radio2 = (RadioButton) findViewById(R.id.radioButton2);
		// radio2.setOnClickListener(radioclick);
		back();
		textView5 = (TextView) findViewById(R.id.textView5);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(onclik);

		mobilenumber = (EditText) findViewById(R.id.mobilenumber);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		retypepass = (EditText) findViewById(R.id.retypepass);
		fname = (EditText) findViewById(R.id.fname);
		lastname = (EditText) findViewById(R.id.lastname);

	}

	// OnClickListener radioclick = new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// if (v == radio1) {
	// radio1.setChecked(true);
	// radio2.setChecked(false);
	// textView5.setText("Your Mobile Number");
	//
	// } else {
	//
	// radio1.setChecked(false);
	// radio2.setChecked(true);
	// textView5.setText("Your Mobile Email");
	// }
	//
	// }
	// };

	OnClickListener onclik = new OnClickListener() {

		@Override
		public void onClick(View v) {
			popup(v);
		}
	};

	String decr() {

		return "";
	}

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

	void popup(final View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle(getResources().getString(R.string.app_name));
		builder.setMessage("Your data will be sent to server via SMS. Standard SMS charges may be applicable from you mobile carrier. Are you sure you want to send data via SMS.");

		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@SuppressWarnings("unchecked")
			public void onClick(DialogInterface dialog, int which) {

				// TODO Auto-generated method stub
				String mobilenumberx, usernamex, passwordx, retypepassx, fnamex, lastnamex;
				mobilenumberx = mobilenumber.getText().toString();
				usernamex = username.getText().toString();
				passwordx = password.getText().toString();
				retypepassx = retypepass.getText().toString();
				fnamex = fname.getText().toString();
				lastnamex = lastname.getText().toString();

				if (mobilenumberx.length() < 9) {
					Toast.makeText(getApplicationContext(),
							"Enter Valid Phone Number", Toast.LENGTH_SHORT)
							.show();
				} else {
					if (!mobilenumberx.equals("") && !usernamex.equals("")
							&& !passwordx.equals("") && !retypepassx.equals("")
							&& !fnamex.equals("") && !lastnamex.equals("")) {

						LocalClass ll =new LocalClass(getApplicationContext());;

						// String pass="D"+usernamex.substring(0, 3)+"";

						String finalstr = "r|D|" + mobilenumberx + "|"
								+ usernamex + "|" + passwordx + "|" + fnamex
								+ "|" + lastnamex;

						int sixdig = Integer.parseInt((mobilenumberx)
								.substring(0, 6));

						int againsix = (sixdig + 187) * 13;
						
						int finalcode = Integer.parseInt(("" + againsix)
								.substring(0, 6));

						System.out.println(finalcode);

						ll.sendSMSsS(StaticVariables.PHONENO, finalstr);

						Intent i = new Intent(RegByDoctor.this, LoginAc.class);
						i.putExtra("NAME", usernamex);
						i.putExtra("PASS", passwordx);
						SharedStoregae SS = SharedStoregae
								.getInstance(getApplicationContext());
						SS.PutApplicationID(passwordx, usernamex);
						SS.onetimepass("" + finalcode, mobilenumberx);
						i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);;
						startActivity(i);
						finish();

						Toast.makeText(getApplicationContext(),
								"Register SuccessFull", Toast.LENGTH_SHORT)
								.show();
					} else {
						Toast.makeText(getApplicationContext(),
								"Enter Valid Data", Toast.LENGTH_SHORT).show();
					}
				}

				dialog.dismiss();
			}

		});

		builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// I do not need any action here you might
				dialog.dismiss();
			}
		});

		AlertDialog alert = builder.create();
		alert.show();

	}

}
