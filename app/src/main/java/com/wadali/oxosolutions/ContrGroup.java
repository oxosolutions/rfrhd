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
import android.widget.RadioButton;
import android.widget.TextView;

import com.wadali.handler.BackAction;
import com.wadali.handler.LocalClass;
import com.wadali.handler.StaticVariables;

public class ContrGroup extends Activity {
	Button submit;

	void button() {
		submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				popup(v);
			}
		});
	}

	void ids() {

		q1a = (RadioButton) findViewById(R.id.one);
		q2a = (RadioButton) findViewById(R.id.two);

		q1b = (RadioButton) findViewById(R.id.four);
		q2b = (RadioButton) findViewById(R.id.five);

		q1b1 = (RadioButton) findViewById(R.id.seven);
		q2b1 = (RadioButton) findViewById(R.id.eight);

		q1c = (RadioButton) findViewById(R.id.ten);
		q2c = (RadioButton) findViewById(R.id.eleven);

		q1c1 = (RadioButton) findViewById(R.id.thteen);
		q2c1 = (RadioButton) findViewById(R.id.fourteen);

		q1d = (RadioButton) findViewById(R.id.sixteen);
		q2d = (RadioButton) findViewById(R.id.seventeen);

		q1E = (RadioButton) findViewById(R.id.eightteen);
		q2E = (RadioButton) findViewById(R.id.nineteen);
		q1F = (RadioButton) findViewById(R.id.twenty);
		q2F = (RadioButton) findViewById(R.id.twentyone);

		q22 = (RadioButton) findViewById(R.id.twentytwo);
		q23 = (RadioButton) findViewById(R.id.twentythree);
		q24 = (RadioButton) findViewById(R.id.twentyfour);
		q25 = (RadioButton) findViewById(R.id.twentyfive);

		q22.setOnClickListener(nineclick);
		q23.setOnClickListener(nineclick);

		q24.setOnClickListener(tenclick);
		q25.setOnClickListener(tenclick);

		q1E.setOnClickListener(sevenclick);
		q2E.setOnClickListener(sevenclick);
		q1F.setOnClickListener(eightclick);
		q2F.setOnClickListener(eightclick);

		q1a.setOnClickListener(radioone);
		q2a.setOnClickListener(radioone);

		q1b.setOnClickListener(radiotwo);
		q2b.setOnClickListener(radiotwo);

		q1b1.setOnClickListener(radiotwoone);
		q2b1.setOnClickListener(radiotwoone);

		q1c.setOnClickListener(radiothree);
		q2c.setOnClickListener(radiothree);

		q1c1.setOnClickListener(radiofour);
		q2c1.setOnClickListener(radiofour);

		q1d.setOnClickListener(sixclick);
		q2d.setOnClickListener(sixclick);
	}

	EditText adddoc, addclic;
	RadioButton q1a, q2a, q3a;
	RadioButton q1b, q2b, q3b;
	RadioButton q1b1, q2b1, q3b1;
	RadioButton q1c, q2c, q3c;
	RadioButton q1c1, q2c1, q3c1;
	RadioButton q1d, q2d;

	RadioButton q1E, q2E;
	RadioButton q1F, q2F;

	RadioButton q22, q23;
	RadioButton q24, q25;

	String one, two, three, four, five, six, nine, ten, elevn, twelve;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contr_group);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		ids();
		back();
		button();
	}

	OnClickListener nineclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q22) {
				q22.setChecked(true);
				q23.setChecked(false);
				elevn = "Y";
			} else if (v == q23) {
				q22.setChecked(false);
				q23.setChecked(true);
				elevn = "N";
			}

		}
	};

	OnClickListener tenclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q24) {
				q24.setChecked(true);
				q25.setChecked(false);
				twelve = "Y";
			} else if (v == q25) {
				q24.setChecked(false);
				q25.setChecked(true);
				twelve = "N";
			}

		}
	};

	OnClickListener eightclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1F) {
				q1F.setChecked(true);
				q2F.setChecked(false);
				ten = "Y";
			} else if (v == q2F) {
				q1F.setChecked(false);
				q2F.setChecked(true);
				ten = "N";
			}

		}
	};

	OnClickListener sevenclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1E) {
				q1E.setChecked(true);
				q2E.setChecked(false);
				nine = "Y";
			} else if (v == q2E) {
				q1E.setChecked(false);
				q2E.setChecked(true);
				nine = "N";
			}

		}
	};

	OnClickListener sixclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1d) {
				q1d.setChecked(true);
				q2d.setChecked(false);
				six = "Y";
			} else if (v == q2d) {
				q1d.setChecked(false);
				q2d.setChecked(true);

				six = "N";
			} else if (v == q3b) {
				q1b.setChecked(false);
				q2b.setChecked(false);
				six = "DK";
			}

		}
	};

	OnClickListener radiotwo = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1b) {
				q1b.setChecked(true);
				q2b.setChecked(false);
				two = "Y";
			} else if (v == q2b) {
				q1b.setChecked(false);
				two = "N";
				q2b.setChecked(true);

			} else if (v == q3b) {
				q1b.setChecked(false);

				two = "DK";
				q2b.setChecked(false);

			}

		}
	};
	OnClickListener radiotwoone = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1b1) {
				q1b1.setChecked(true);
				q2b1.setChecked(false);
				three = "Y";
			} else if (v == q2b1) {
				q1b1.setChecked(false);
				q2b1.setChecked(true);
				three = "N";
			} else if (v == q3b1) {
				q1b1.setChecked(false);
				q2b1.setChecked(false);

				three = "DK";
			}

		}
	};
	OnClickListener radiofour = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1c1) {
				q1c1.setChecked(true);
				q2c1.setChecked(false);
				five = "Y";

			} else if (v == q2c1) {
				q1c1.setChecked(false);
				q2c1.setChecked(true);
				five = "N";
			} else if (v == q3c1) {
				q1c1.setChecked(false);
				q2c1.setChecked(false);
				five = "DK";
			}

		}
	};
	OnClickListener radiothree = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1c) {
				q1c.setChecked(true);
				q2c.setChecked(false);
				four = "Y";
			} else if (v == q2c) {
				q1c.setChecked(false);
				q2c.setChecked(true);
				four = "N";
			} else if (v == q3c) {
				q1c.setChecked(false);
				q2c.setChecked(false);
				four = "DK";
			}

		}
	};

	OnClickListener radioone = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1a) {
				q1a.setChecked(true);
				q2a.setChecked(false);
				one = "Y";
			} else if (v == q2a) {
				q1a.setChecked(false);
				q2a.setChecked(true);
				one = "N";
			} else if (v == q3a) {
				q1a.setChecked(false);
				q2a.setChecked(false);
				one = "DK";
			}

		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.contr_group, menu);

		return true;
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

			public void onClick(DialogInterface dialog, int which) {

				String finl = "CG|" + one + "|" + two + "|" + three + "|"
						+ four + "|" + five + "|" + six + "|" + nine + "|"
						+ ten + "|" + elevn + "|" + twelve;

				LocalClass clas = new LocalClass(getApplicationContext());
				clas.sendSMSsS(StaticVariables.PHONENO, finl);

				finish();

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
