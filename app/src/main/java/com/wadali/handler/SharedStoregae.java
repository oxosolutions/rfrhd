package com.wadali.handler;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedStoregae {

	SharedPreferences myshared_pregrence;

	private static SharedStoregae instance = null;

	private SharedStoregae(Context context) {
		myshared_pregrence = context.getSharedPreferences("CPD",
				Context.MODE_PRIVATE);
	}

	public static SharedStoregae getInstance(Context context) {
		if (instance == null) {
			synchronized (SharedStoregae.class) {
				if (instance == null) {
					instance = new SharedStoregae(context);
				}
			}
		}
		return instance;
	}



	public String ListName() {
		if (myshared_pregrence.contains(StaticVariables.LISTNAME)) {
			return myshared_pregrence.getString(StaticVariables.LISTNAME, "");

		} else
			return "My Shoping List";
	}

	public void UpdateListname(String Listname) {
		Editor editor = myshared_pregrence.edit();
		editor.putString(StaticVariables.LISTNAME, Listname);
		editor.commit();

	}

	public void FirstRun() {
		Editor editor = myshared_pregrence.edit();
		editor.putBoolean(StaticVariables.FIRSTRUN, true);
		editor.commit();

	}
	public boolean FirstrunCheck() {
		if (myshared_pregrence.contains(StaticVariables.FIRSTRUN))
			return true;
		else
			return false;
	}
	public void fbregisterresponce(String zibID) {
		Editor editor = myshared_pregrence.edit();
		editor.putString("ID", zibID);
		editor.commit();
	}

	public void PutApplicationID(String uid, String name) {
		Editor editor = myshared_pregrence.edit();
		editor.putString("PASS", uid);
		editor.putString("NAME", name);
		editor.commit();
	}

	public void onetimepass(String sixdigit, String mobi) {
		Editor editor = myshared_pregrence.edit();
		editor.putString("SIXDIGIT", sixdigit);
		editor.putString("MOBILE", mobi);
		editor.commit();
	}

	public String getactiivation() {
		if (myshared_pregrence.contains("SIXDIGIT")) {
			return myshared_pregrence.getString("SIXDIGIT", "INVALID");

		} else
			return "INVALID";
	}

	public String GETPASS() {
		if (myshared_pregrence.contains("PASS")) {
			return myshared_pregrence.getString("PASS", "INVALID");

		} else
			return "INVALID";
	}

	public String GETNAME() {
		if (myshared_pregrence.contains("NAME")) {
			return myshared_pregrence.getString("NAME", "INVALID");

		} else
			return "INVALID";
	}

	public void InsertProfileData(String json) {
		Editor editor = myshared_pregrence.edit();
		editor.putString("profiledatajson", json);
		editor.commit();
	}

	public void sound(Boolean flag) {
		Editor editor = myshared_pregrence.edit();
		editor.putBoolean("sound", flag);
		editor.commit();
	}

	

	public boolean Check() {
		if (myshared_pregrence.contains("NAME")) {
			boolean profiledatajson = myshared_pregrence.getBoolean("NAME",
					false);
			return profiledatajson;
		} else {
			return false;
		}
	}
	public void vibration(Boolean flag) {
		Editor editor = myshared_pregrence.edit();
		editor.putBoolean("vibration", flag);
		editor.commit();
	}
	public boolean vibrationcheck() {
		if (myshared_pregrence.contains("vibration")) {
			boolean profiledatajson = myshared_pregrence.getBoolean(
					"vibration", false);
			return profiledatajson;
		} else {
			return false;
		}
	}

	
	public void activated(Boolean flag) {
		Editor editor = myshared_pregrence.edit();
		editor.putBoolean("Active", flag);
		editor.commit();
	}
	public boolean checkactivated() {
		if (myshared_pregrence.contains("Active")) {
			boolean profiledatajson = myshared_pregrence.getBoolean(
					"Active", false);
			return profiledatajson;
		} else {
			return false;
		}
	}
	
	
	public String GetProfileData() {
		if (myshared_pregrence.contains("profiledatajson")) {
			String profiledatajson = myshared_pregrence.getString(
					"profiledatajson", "");
			return profiledatajson;
		} else {
			return "null";
		}
	}

	public void LoginResponceShared(String Firstname, String Lastname,
			String Email, String Gender, String dob, String Profilepic,
			String Password, String Usertype, String Facebookid,
			Context context, String Userid) {
		Editor editor = myshared_pregrence.edit();
		editor.putString("Firstname", Firstname);
		editor.putString("Lastname", Lastname);
		editor.putString("Email", Email);
		editor.putString("Gender", Gender);
		editor.putString("dob", dob);
		editor.putString("Profilepic", Profilepic);
		editor.putString("Password", Password);
		editor.putString("Usertype", Usertype);
		editor.putString("Facebookid", Facebookid);
		editor.putString("Userid", Userid);
		editor.commit();

	}

	public void Radio() {

	}

	public void clear() {

		if (myshared_pregrence.contains("uid"))
			myshared_pregrence.edit().clear().commit();

	}

	public boolean sharedcheck() {
		if (myshared_pregrence.contains("uid")) {
			String uid = myshared_pregrence.getString("uid", "");
			System.out.println(uid);
			return true;
		} else {
			return false;
		}
	}

	public String getid() {
		if (myshared_pregrence.contains("uid")) {
			String myid = myshared_pregrence.getString("uid", "");
			System.out.println(myid);
			return myid;
		} else {
			return " ";
		}
	}

}
