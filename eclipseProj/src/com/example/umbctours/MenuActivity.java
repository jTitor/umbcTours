package com.example.umbctours;

import com.example.umbctours.Audio.SoundCue;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.renderscript.Type.CubemapFace;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;

public class MenuActivity extends Activity implements OnClickListener {

	private Resources res;
	public void onClick(View view)
	{
		//Get the tag of this button
		//and lookup for its building info.
		Object viewTag = view.getTag();
		
		//If there was no info, complain in logs.
		//For now, don't tell the user anything.
		if(viewTag == null)
		{
			Log.w("UI", "Menu button " + view + " is missing tag, aborting click");
			return;
		}
		
		ButtonInfo btnInf = (ButtonInfo)viewTag;
		
		//Otherwise, send building info to building details activity.
		Intent goToDetails = new Intent(this, BuildingInfoActivity.class);
		goToDetails.putExtra(getPackageName() + R.string.extra_bldgId, btnInf.GetBuildingId());
		//Play a noise, then go to the detail activity.
		Audio.GetInstance().PlaySound(SoundCue.ButtonPress);
		startActivity(goToDetails);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		res = getResources();
		//Go get the list of building tags.
		TypedArray buildings = res.obtainTypedArray(R.array.buildings);
		LinearLayout btnList = (LinearLayout)findViewById(R.id.BuildingContent);
		//Add buttons for each building.
		for(int i = 0; i < buildings.length(); ++i)
		{
			//Get the building entry first.
			int buildingRes = buildings.getResourceId(i, -1);
			if(buildingRes != -1)
			{
				TypedArray building = res.obtainTypedArray(buildingRes);
				String label = building.getString(0);
				Button b = new Button(getApplicationContext());
				b.setTag(new ButtonInfo(buildingRes, label));
				//Building name is assumed to be first
				//in building array.
				b.setText(label);
				b.setOnClickListener(this);
				btnList.addView(b);
				building.recycle();
			}
		}
		
		//Clean up the resource arrays.
		buildings.recycle();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
