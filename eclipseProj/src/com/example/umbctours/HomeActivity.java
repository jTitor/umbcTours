package com.example.umbctours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class HomeActivity extends ActionBarActivity implements OnClickListener
{

	public void onClick(View view)
	{
		
		int buttonId = view.getId();
		Class<?> activityClass;
		switch(buttonId)
		{
			case R.id.button_map:
				activityClass = MapActivity.class;
				break;
			case R.id.button_list:
				activityClass = MenuActivity.class;
				break;
			case R.id.button_faq:
				activityClass = FaqActivity.class;
				break;
			case R.id.button_about:
				activityClass = AboutActivity.class;
				break;
			default:
				return;
		}
		
		Intent goToDetails = new Intent(this, activityClass);
		startActivity(goToDetails);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//Set up the audio instance.
		Audio audio = new Audio();
		Audio.SetInstance(audio);
		//Load up any sounds here.
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}