package com.example.umbctours;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingInfoActivity extends Activity{
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		
		//Recover building ID from the intent that
		//spawned us.
		Intent intent = getIntent();
		Resources res = getResources();
		int bldgId = intent.getIntExtra(getPackageName() + R.string.extra_bldgId, -1);
		//If there was no id, abort!
		if(bldgId == -1)
		{
			return;
		}
		
		//Otherwise, set up window details.
		TypedArray building = res.obtainTypedArray(bldgId);
		String bName = building.getString(0);
		String bDesc = building.getString(1);

		int bImage      = building.getResourceId(2, -1);
		ImageView bImageView = (ImageView)findViewById(R.id.BuildingImage);
		TextView bNameLabel  = (TextView)findViewById(R.id.BuildingName);
		TextView bDescLabel  = (TextView)findViewById(R.id.BuildingText);

		int width = bImageView.getWidth();
		bImageView.setImageBitmap(DrawableUtils.LoadDrawable(res, bImage, width, -1));//BitmapFactory.decodeResource(res, bImage, opts));
		//bImageView.setImageDrawable(bImage);
		bNameLabel.setText(bName);
		bDescLabel.setText(bDesc);
		
		building.recycle();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.building_info, menu);
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
	
	public void goToMap(View v) {
		Intent goToMap = new Intent(this, MapActivity.class);
		// TODO add info for specific building to intent
		startActivity(goToMap);
	}
}
