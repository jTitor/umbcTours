package com.example.umbctours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {

	//The minimum amount of time the splash screen will be on screen, in seconds.
	private static final float MIN_SPLASH_LIFETIME_SECS = 1.0f; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//Initialize everything here.
		//Request that we load the main menu after (MIN_SPLASH_LIFETIME_SECS).
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				//Load up the main menu.
				Intent goToMenu = new Intent(SplashActivity.this, MenuActivity.class);
				startActivity(goToMenu);
				//Close *this* activity, since it's just a splash screen.
				SplashActivity.this.finish();
			}
		}, (long)(MIN_SPLASH_LIFETIME_SECS * 1000));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
