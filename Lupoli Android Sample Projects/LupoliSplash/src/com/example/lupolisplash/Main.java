package com.example.lupolisplash;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Main extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                
        Thread splashTimer = new Thread(){
			
			public void run() {
				// TODO Auto-generated method stub
				try {
					sleep(5000);
					startActivity(new Intent(Main.this, Splash.class));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally{ /*finish(); */ }
			}
		
		};
		splashTimer.start();
		

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
