package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {

	// setup Base components here so everyone in the class has access
	Button btnFood, btnToy, btnSite;
	
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnFood = (Button) findViewById(R.id.btnFood);
        btnToy = (Button) findViewById(R.id.btnToy);
        btnSite = (Button) findViewById(R.id.btnSite);
        
        btnFood.setOnClickListener(new ButtonListener());
        btnToy.setOnClickListener(new ButtonListener());
        btnSite.setOnClickListener(new ButtonListener());   
    }

    private class ButtonListener implements OnClickListener
    {
    	public void onClick(View V)
    	{
    		//if(V.getId() == R.id.btnFood)
    		
    		if(btnFood.getId() == ((Button)V).getId())
    		{ startActivity(new Intent(Main.this, Food.class)); }
    		else if(btnToy.getId() == ((Button)V).getId())
    		{ startActivity(new Intent(Main.this, Toy.class)); }
    		else if(btnSite.getId() == ((Button)V).getId())
    		{ startActivity(new Intent(Main.this, Site.class)); }
    		else {} 
    	}
    	
    }
    
    
}
