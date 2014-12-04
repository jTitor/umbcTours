package com.example.umbctours;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	}

	//Called whenever we're visible to the user.
	@Override
	protected void onResume()
	{
		try
		{
			wait((long)(MIN_SPLASH_LIFETIME_SECS * 1000));
		}
		catch (InterruptedException e)
		{
			//This is the splash screen,
			//we really don't care that much if we're interrupted.
			//Skip to the main menu, then.
		}
		
		//Load up the main menu.
		Intent goToMenu = new Intent(this, MenuActivity.class);
		startActivity(goToMenu);
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
