package com.wadali.oxosolutions;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.wadali.handler.BackAction;

public class Loader extends Activity {

	@SuppressLint("SetJavaScriptEnabled") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
		ActionBar abs = getActionBar();
		back();
		abs.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#168DC5")));// C
	
		Intent i = getIntent();

		String loading = i.getStringExtra("url");
		WebView wv;
		
		wv = (WebView) findViewById(R.id.loader);
		wv.setWebChromeClient(new WebChromeClient()); 
		wv.setWebViewClient(new WebViewClient()); 
		wv.getSettings().setJavaScriptEnabled(true); 
		wv.loadUrl("file:///android_asset/" + loading);

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
}
