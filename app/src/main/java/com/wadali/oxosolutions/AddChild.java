package com.wadali.oxosolutions;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.wadali.handler.BackAction;
import com.wadali.handler.DatabaseHelper;
import com.wadali.handler.LocalClass;
import com.wadali.handler.Product_Model;
import com.wadali.handler.SharedStoregae;
import com.wadali.handler.StaticVariables;

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
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddChild extends Activity {

	EditText childname, chilclass, ptmb;
	TextView timer;
	Button btn;
	RadioButton radio1, radio2;
	boolean timerselect = false;
	Button submit;
	List<Product_Model> list;
	DatabaseHelper helper;

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

	Spinner autocomplete;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_child);
		ActionBar abs = getActionBar();
		back();
		ptmb = (EditText) findViewById(R.id.ptmb);
		autocomplete = (Spinner) findViewById(R.id.chilschool);
		helper = new DatabaseHelper(getApplicationContext());
		list = helper.Searchings("");
		String[] array = new String[list.size()];
		int i = 0;
		for (Product_Model ix : list) {
			array[i] = ix.getName();
			i++;
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.test_list_item, array);
		// autocomplete.
		// autocomplete.setThreshold(1);
		autocomplete.setOnItemSelectedListener(onclik);

		autocomplete.setAdapter(adapter);
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
		radio1 = (RadioButton) findViewById(R.id.maleradio);
		radio1.setOnClickListener(radioclick);
		radio2 = (RadioButton) findViewById(R.id.femaleradio);
		radio2.setOnClickListener(radioclick);
		timer = (TextView) findViewById(R.id.timer);
		btn = (Button) findViewById(R.id.submitone);
		btn.setOnClickListener(onclick);
		// button() ;
		timer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				periodfrom();
			}
		});
		chilclass = (EditText) findViewById(R.id.chilclass);
		childname = (EditText) findViewById(R.id.childname);
	}

	String schoolid = "U";
	OnItemSelectedListener onclik = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			schoolid = list.get(arg2).getID();

		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	};

	// new OnItemClickListener() {
	//
	// @Override
	// public void onItemClick(AdapterView<?> parent, View view, int position,
	// long id) {
	// schoolid = list.get(position).getID();
	//
	// }
	// };

	android.view.View.OnClickListener onclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			popup(v);
		}
	};
	String datepat = "";

	@SuppressLint("NewApi")
	private void periodfrom() {

		Calendar cal = new GregorianCalendar();
		// cal.setTime(date);
		int myear = cal.get(Calendar.YEAR);
		int mmonthOfYear = cal.get(Calendar.MONTH);
		int mdayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		DatePickerDialog dateobj = new DatePickerDialog(AddChild.this,
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

						datepat = d + "" + m + "" + updatedate__year;
						timerselect = true;

					}
				}, myear, mmonthOfYear, mdayOfMonth);
		dateobj.getDatePicker().setMaxDate(cal.getTimeInMillis());

		dateobj.show();
	}

	String gender = "M";
	boolean firstclick = false;

	OnClickListener radioclick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			firstclick = true;
			if (v == radio1) {
				radio1.setChecked(true);
				radio2.setChecked(false);
				gender = "M";

			} else {

				radio1.setChecked(false);
				radio2.setChecked(true);
				gender = "F";
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

			@SuppressWarnings("unchecked")
			public void onClick(DialogInterface dialog, int which) {

				String childnamex = childname.getText().toString();
				String chidclasx = chilclass.getText().toString();
				String dob = timer.getText().toString();
				LocalClass cla = new LocalClass(getApplicationContext());

				SharedStoregae ss = SharedStoregae
						.getInstance(getApplicationContext());
				String uname = ss.GETNAME();
				String threedig = (childnamex).substring(0, 3);

				String username = (uname).substring(0, 3);

				String withdob = threedig + datepat + "p" + username;

				System.out.println(withdob);

				String finalsString = "c|" + withdob + "|" + dob + "|" + gender
						+ "|" + chidclasx + "|" + schoolid + "|"
						+ ptmb.getText().toString();
				if (!chidclasx.equals("") && !childnamex.equals("")
						&& timerselect && firstclick
						&& !ptmb.getText().toString().equals("")) {

					if (ptmb.length() < 9) {
						Toast.makeText(getApplicationContext(),
								"Enter Valid Phone Number", Toast.LENGTH_SHORT)
								.show();
					} else {
						cla.sendSMSsS(StaticVariables.PHONENO, finalsString);

						helper.InsertItem(childnamex, withdob);

						finish();
						Toast.makeText(getApplicationContext(),
								"Child Added Sucessfull", Toast.LENGTH_SHORT)
								.show();
					}

				} else {
					Toast.makeText(getApplicationContext(),
							"Please Enter Valid data", Toast.LENGTH_SHORT)
							.show();
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
