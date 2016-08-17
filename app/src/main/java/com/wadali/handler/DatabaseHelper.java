package com.wadali.handler;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	static String NAME = "helo";
	static int VERSION = 1;
	Context context;
	public DatabaseHelper(Context context) {
		super(context, NAME, null, 1);
		this.context=context;
	}

	static String TableName = "CPO";
	static String Name = "NAME";
	static String ID = "IX";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TableName + "(" + Name + " TEXT," + ID
				+ " TEXT);");
        //db.execSQL("INSERT INTO " + TableName + " VALUES (My School, 2652);");


	}

	public String InsertItem(String Name, String model) {
		ContentValues value = new ContentValues();
		value.put(this.Name, Name);
		value.put(ID, model);
		SQLiteDatabase db = getWritableDatabase();
		db = getWritableDatabase();
		long Effectedrows = db.insert(TableName, null, value);
		db.close();
		return Long.toString(Effectedrows);
	}
	public void copyDataBase() {
		try {
			getWritableDatabase();
			InputStream mInput = context.getAssets().open(NAME);
			// String outFileName = DB_PATH + DB_NAME;
			OutputStream mOutput = new FileOutputStream(
					context.getDatabasePath(NAME));
			byte[] mBuffer = new byte[1024];
			int mLength;
			while ((mLength = mInput.read(mBuffer)) > 0) {
				mOutput.write(mBuffer, 0, mLength);
			}
			mOutput.flush();
			mOutput.close();
			mInput.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ex" + e);
		}
	}

	public List<Product_Model> Searching(String word) {
		List<Product_Model> list = new ArrayList<Product_Model>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM " + TableName + ";", null);
		cursor.moveToFirst();
		while (cursor.isAfterLast() == false) {

			Product_Model model= new Product_Model();
			model.setName(cursor.getString(cursor.getColumnIndex(Name)));
			model.setID(cursor.getString(cursor.getColumnIndex(ID)));
			list.add(model);
			cursor.moveToNext();

		}
		cursor.close();

		return list;
	}

	
	
	public List<Product_Model> Searchings(String word) {
		List<Product_Model> list = new ArrayList<Product_Model>();
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT * FROM " + "schools" + ";", null);
		cursor.moveToFirst();
		while (cursor.isAfterLast() == false) {
			Product_Model model= new Product_Model();
			model.setName(cursor.getString(cursor.getColumnIndex("school_name")));
			model.setID(cursor.getString(cursor.getColumnIndex("school_id")));
			list.add(model);
			cursor.moveToNext();
		}
		cursor.close();

		return list;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
