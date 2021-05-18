package com.unitglo.foodscience;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.splash_screen);

		image1 = (ImageView) findViewById(R.id.bubble1);
		image2 = (ImageView) findViewById(R.id.bubble2);
		StaticLists.FillFruatsInfo();
		StaticLists.FillVegetablesInfo();
		zoomAnimation1();
		zoomAnimation2();
		Thread background = new Thread() {
			public void run() {
				try {

					sleep(4 * 1000);
					Intent i = new Intent(getBaseContext(), Main.class);
					startActivity(i);
					finish();


				} catch (Exception e) {
				}
			}
		};

		background.start();

	}

	private void zoomAnimation1() {
		Animation animation = AnimationUtils.loadAnimation(
				getApplicationContext(), R.anim.move1);
		image1.startAnimation(animation);

	}

	private void zoomAnimation2() {
		Animation animation = AnimationUtils.loadAnimation(
				getApplicationContext(), R.anim.move2);
		image2.startAnimation(animation);
	}

	@Override
	protected void onDestroy() {

		super.onDestroy();

	}

	ImageView image1, image2;
}
