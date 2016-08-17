package com.wadali.oxosolutions;

import java.util.ArrayList;
import java.util.List;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wadali.handler.BackAction;
import com.wadali.handler.DatabaseHelper;
import com.wadali.handler.LocalClass;
import com.wadali.handler.Product_Model;
import com.wadali.handler.StaticVariables;

public class Adddigno extends Activity {

	Spinner spinner1;
	DatabaseHelper helper;
	List<Product_Model> name;

	Button submit;

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

	void button() {
		submit = (Button) findViewById(R.id.button1);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				popup(v);

			}
		});
	}

	String q1String = "", q1aString = "", q2String = "", q2aString = "",
			q3String = "", q3aString = "";

	void ids() {

		adddoct = (EditText) findViewById(R.id.ADdoctorname);
		addclict = (EditText) findViewById(R.id.adclinicph);

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		helper = new DatabaseHelper(getApplicationContext());
		name = helper.Searching("");
		String[] arraString = new String[name.size()];
		int ix = 0;
		for (Product_Model item : name) {

			arraString[ix] = item.getName();
			ix++;
		}

		ArrayAdapter<String> catagryadpter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arraString);

		spinner1.setAdapter(catagryadpter);
		spinner1.setOnItemSelectedListener(itemseletc);

		q1a = (RadioButton) findViewById(R.id.one);
		q2a = (RadioButton) findViewById(R.id.two);
		q3a = (RadioButton) findViewById(R.id.three);

		q1b = (RadioButton) findViewById(R.id.four);
		q2b = (RadioButton) findViewById(R.id.five);
		q3b = (RadioButton) findViewById(R.id.six);

		q1b1 = (RadioButton) findViewById(R.id.seven);
		q2b1 = (RadioButton) findViewById(R.id.eight);
		q3b1 = (RadioButton) findViewById(R.id.nine);

		q1c = (RadioButton) findViewById(R.id.ten);
		q2c = (RadioButton) findViewById(R.id.evleven);
		q3c = (RadioButton) findViewById(R.id.twelve);

		q1c1 = (RadioButton) findViewById(R.id.thteen);
		q2c1 = (RadioButton) findViewById(R.id.fouteen);
		q3c1 = (RadioButton) findViewById(R.id.fifteen);

		q1D = (CheckBox) findViewById(R.id.sixteen);
		q2D = (CheckBox) findViewById(R.id.seventeen);
		q3D = (CheckBox) findViewById(R.id.eighteen);
		q4D = (CheckBox) findViewById(R.id.ninteen);

		q1D.setOnClickListener(radiolast);
		q2D.setOnClickListener(radiolast);
		q3D.setOnClickListener(radiolast);
		q4D.setOnClickListener(radiolast);

		q1a.setOnClickListener(radioone);
		q2a.setOnClickListener(radioone);
		q3a.setOnClickListener(radioone);

		q1b.setOnClickListener(radiotwo);
		q2b.setOnClickListener(radiotwo);
		q3b.setOnClickListener(radiotwo);

		q1b1.setOnClickListener(radiotwoone);
		q2b1.setOnClickListener(radiotwoone);
		q3b1.setOnClickListener(radiotwoone);

		q1c.setOnClickListener(radiothree);
		q2c.setOnClickListener(radiothree);
		q3c.setOnClickListener(radiothree);

		q1c1.setOnClickListener(radiofour);
		q2c1.setOnClickListener(radiofour);
		q3c1.setOnClickListener(radiofour);

		resizeone = (LinearLayout) findViewById(R.id.resizeone);
		resizetwo = (LinearLayout) findViewById(R.id.resizetwo);
		resizethree = (LinearLayout) findViewById(R.id.resizethree);

	}

	EditText adddoct, addclict;
	RadioButton q1a, q2a, q3a;
	RadioButton q1b, q2b, q3b;
	RadioButton q1b1, q2b1, q3b1;
	RadioButton q1c, q2c, q3c;
	RadioButton q1c1, q2c1, q3c1;

	CheckBox q1D, q2D, q3D, q4D;

	LinearLayout resizeone, resizetwo, resizethree;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adddigno);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		ids();
		back();
		button();
	}

	String chilDKey;

	OnItemSelectedListener itemseletc = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			chilDKey = name.get(position).getID();

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	OnClickListener radiotwo = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1b) {
				resizetwo.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				q1b.setChecked(true);
				q2b.setChecked(false);
				q3b.setChecked(false);
				q2String = "Y";
			} else if (v == q2b) {
				resizetwo.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));
				q1b.setChecked(false);
				q2b.setChecked(true);
				q3b.setChecked(false);
				q2String = "N";
			} else if (v == q3b) {
				resizetwo.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));

				q1b.setChecked(false);
				q2b.setChecked(false);
				q3b.setChecked(true);
				q2String = "DK";
			}

		}
	};
	OnClickListener radiotwoone = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1b1) {

				q1b1.setChecked(true);
				q2b1.setChecked(false);
				q3b1.setChecked(false);
				q2aString = "Y";
			} else if (v == q2b1) {

				q1b1.setChecked(false);
				q2b1.setChecked(true);
				q3b1.setChecked(false);
				q2aString = "N";
			} else if (v == q3b1) {
				q1b1.setChecked(false);
				q2b1.setChecked(false);
				q3b1.setChecked(true);
				q2aString = "DK";
			}

		}
	};
	OnClickListener radiofour = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1c1) {
				q1c1.setChecked(true);
				q2c1.setChecked(false);
				q3c1.setChecked(false);
				q3aString = "Y";
			} else if (v == q2c1) {
				q1c1.setChecked(false);
				q2c1.setChecked(true);
				q3c1.setChecked(false);
				q3aString = "N";

			} else if (v == q3c1) {
				q1c1.setChecked(false);
				q2c1.setChecked(false);
				q3c1.setChecked(true);
				q3aString = "DN";

			}

		}
	};
	OnClickListener radiothree = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1c) {
				resizethree.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				q1c.setChecked(true);
				q2c.setChecked(false);
				q3c.setChecked(false);
				q3String = "Y";

			} else if (v == q2c) {
				resizethree.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));
				q1c.setChecked(false);
				q2c.setChecked(true);
				q3c.setChecked(false);
				q3String = "N";

			} else if (v == q3c) {
				resizethree.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));
				q1c.setChecked(false);
				q2c.setChecked(false);
				q3c.setChecked(true);
				q3String = "DN";

			}

		}
	};

	List<String> list = new ArrayList<String>();
	OnClickListener radiolast = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1D) {

				if (list.contains("a")) {
					q1D.setChecked(false);
					list.remove("a");
				} else {
					q1D.setChecked(true);
					list.add("a");
				}

			} else if (v == q2D) {

				if (list.contains("b")) {
					q2D.setChecked(false);
					list.remove("b");
				} else {
					list.add("b");
					q2D.setChecked(true);
				}

			} else if (v == q3D) {
				if (list.contains("c")) {
					list.remove("c");
					q3D.setChecked(false);

				} else {
					q3D.setChecked(true);
					list.add("c");
				}
			} else if (v == q4D) {

				if (list.contains("d")) {
					q4D.setChecked(false);
					list.remove("d");
				} else {
					list.add("d");
					q4D.setChecked(true);
				}
			}

		}
	};

	OnClickListener radioone = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1a) {
				resizeone.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				q1a.setChecked(true);
				q2a.setChecked(false);
				q3a.setChecked(false);
				q1String = "Y";

			} else if (v == q2a) {
				resizeone.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));

				q1a.setChecked(false);
				q2a.setChecked(true);
				q3a.setChecked(false);
				q1String = "N";
			} else if (v == q3a) {
				resizeone.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));
				q1a.setChecked(false);
				q2a.setChecked(false);
				q3a.setChecked(true);
				q1String = "DK";
			}

		}
	};

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

	void popup(final View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle(getResources().getString(R.string.app_name));
		builder.setMessage("Your data will be sent to server via SMS. Standard SMS charges may be applicable from you mobile carrier. Are you sure you want to send data via SMS.");

		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {

				if (chilDKey == null) {
					Toast.makeText(getApplicationContext(), "Add Child First",
							Toast.LENGTH_LONG).show();
				} else {
					
					String csv = list.toString().replace("[", "").replace("]", "")
				            .replace(", ", ",");
					
					
					String fnal = "d|" + chilDKey + "|" + q1String + "|"
							+ adddoct.getText().toString() + "|"
							+ addclict.getText().toString() + "|" + q2String
							+ "|" + q2aString + "|" + q3String + "|"
							+ q3aString + "|" + csv;
					// Toast.makeText(getApplicationContext(), fnal,
					// Toast.LENGTH_LONG)
					// .show();

					LocalClass clas =new LocalClass(getApplicationContext());
					clas.sendSMSsS(StaticVariables.PHONENO, fnal);
					finish();
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
