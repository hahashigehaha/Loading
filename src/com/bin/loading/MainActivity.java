package com.bin.loading;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Loading loading = new Loading(MainActivity.this);
		setContentView(loading.initConfig());
		
	}
}
