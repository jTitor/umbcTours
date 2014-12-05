package com.example.umbctours;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.R.integer;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class MapActivity extends ActionBarActivity {

	private GoogleMap mMap;
	private Resources res;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		setUpMapIfNeeded();
		res = getResources();
		TypedArray buildings = res.obtainTypedArray(R.array.buildings);
		for (int i = 0; i < buildings.length(); i++) {
			//Get the building entry first.
			int buildingRes = buildings.getResourceId(i, -1);
			if(buildingRes != -1)
			{
				TypedArray building = res.obtainTypedArray(buildingRes);
				Log.w("UI", "Added marker");
				MarkerOptions newMarker = new MarkerOptions()
									.position(new LatLng(building.getFloat(3,0), building.getFloat(4,0)));
				newMarker.title(building.getString(0));
				// TODO make snippet a link to info page
				newMarker.snippet(building.getString(1));
				mMap.addMarker(newMarker);
				building.recycle();
			}
		}
		buildings.recycle();
	}
	
	@SuppressLint("NewApi")
	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the map.
		if (mMap == null) {
			mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			if (mMap != null) {
				// The Map is verified. It is now safe to manipulate the map.
	        }
	    }
	}
}
