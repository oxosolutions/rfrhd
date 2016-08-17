package com.wadali.oxosolutions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.wadali.handler.BackAction;
import com.wadali.handler.DatabaseHelper;
import com.wadali.handler.LocalClass;
import com.wadali.handler.Product_Model;
import com.wadali.handler.StaticVariables;

public class AddOutcome extends Activity {

	Spinner spinner1;
	DatabaseHelper helper;
	List<Product_Model> name;
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
		timer = (TextView) findViewById(R.id.timere);
		timer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				periodfrom();
			}
		});
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

		q1b = (RadioButton) findViewById(R.id.four);
		q2b = (RadioButton) findViewById(R.id.five);
		q3b = (RadioButton) findViewById(R.id.six);

		q1a.setOnClickListener(radioone);
		q2a.setOnClickListener(radioone);

		q1b.setOnClickListener(radiotwo);
		q2b.setOnClickListener(radiotwo);
		q3b.setOnClickListener(radiotwo);

		resizeone = (LinearLayout) findViewById(R.id.resizeone);
		resizetwo = (LinearLayout) findViewById(R.id.resizetwo);

	}

	LinearLayout resizeone, resizetwo;
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
	OnClickListener radioone = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (v == q1a) {

				resizeone.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));

				q1a.setChecked(true);
				q2a.setChecked(false);
				q1String = "Y";
			} else if (v == q2a) {
				resizeone.setLayoutParams(new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT, 0));
				q1a.setChecked(false);
				q2a.setChecked(true);

				q1String = "N";
			}

		}
	};
	EditText adddoc, addclic;
	RadioButton q1a, q2a;
	RadioButton q1b, q2b, q3b;
	String q1String, q1aString, q2String, dateofbth;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_outcome);
		ActionBar abs = getActionBar();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		adddoc = (EditText) findViewById(R.id.ADdoctorname);
		ids();
		back();
		button();
	}

	String childname;
	OnItemSelectedListener itemseletc = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			childname = name.get(position).getID();

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
	};

	TextView timer;
	boolean timerselect = false;

	@SuppressLint("NewApi")
	private void periodfrom() {

		Date date;
		Calendar cal = new GregorianCalendar();
		// cal.setTime(date);
		int myear = cal.get(Calendar.YEAR);
		int mmonthOfYear = cal.get(Calendar.MONTH);
		int mdayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		DatePickerDialog dateobj = new DatePickerDialog(AddOutcome.this,
				new DatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						// TODO Auto-generated method stub
						
						
						int updatedate_day, updatedate__year, updatedate__month;
						updatedate__month = monthOfYear + 1;
						updatedate_day = dayOfMonth;
						updatedate__year = year;

						String d = "" + updatedate_day;
						String m = "" + updatedate__month;

						int length = (int) Math.log10(updatedate__month) + 1;
						if (length == 1) {
							m = "0" + updatedate__month;
						}
						int length2 = (int) Math.log10(updatedate_day) + 1;
						if (length2 == 1) {
							d = "0" + updatedate_day;
						}

						timer.setText(d + "/" + m + "/" + updatedate__year);
//
//						datepat = d + "" + m + "" + updatedate__year;
//						
//						
//						
//						
//						int updatedate_day, updatedate__year, updatedate__month;
//						updatedate__month = monthOfYear + 1;
//						updatedate_day = dayOfMonth;
//						updatedate__year = year;
//
//						timer.setText(updatedate__month + "/" + updatedate_day
//								+ "/" + updatedate__year);
//						// myear = updatedate__year;
//						// mmonthOfYear = updatedate__month;
//						// mdayOfMonth = updatedate_day;

						timerselect = true;

					}
				}, myear, mmonthOfYear, mdayOfMonth);
		dateobj.getDatePicker().setMaxDate(cal.getTimeInMillis());

		dateobj.show();
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

			public void onClick(DialogInterface dialog, int which) {

				String fin = "o|" + childname + "|" + q1String + "|"
						+ adddoc.getText().toString() + "|" + q2String + "|"
						+ timer.getText().toString();

				LocalClass clas = new LocalClass(getApplicationContext());
				clas.sendSMSsS(StaticVariables.PHONENO, fin);
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
