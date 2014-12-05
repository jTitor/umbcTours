package com.example.umbctours;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class MapActivity extends ActionBarActivity  implements OnInfoWindowClickListener{

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
				MarkerOptions newMarker = new MarkerOptions()
									.position(new LatLng(building.getFloat(3,0), building.getFloat(4,0)));
				newMarker.title(building.getString(0));
				newMarker.snippet("Tap for Details");
				mMap.addMarker(newMarker);
				building.recycle();
			}
		}
		buildings.recycle();
		
		mMap.setOnInfoWindowClickListener(this);
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

	@Override
	public void onInfoWindowClick(Marker marker) {
		TypedArray buildings = res.obtainTypedArray(R.array.buildings);
		for (int i = 0; i < buildings.length(); i++) {
			//Get the building entry first.
			int buildingRes = buildings.getResourceId(i, -1);
			if(buildingRes != -1)
			{
				TypedArray building = res.obtainTypedArray(buildingRes);
				if (marker.getTitle().equals(building.getString(0))) {
					Intent goToDetails = new Intent(this, BuildingInfoActivity.class);
					goToDetails.putExtra(getPackageName() + R.string.extra_bldgId, buildingRes);
					startActivity(goToDetails);
				}
				building.recycle();
			}
		}
		buildings.recycle();
	}
}
