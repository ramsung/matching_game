package com.beyonity.matchinggame;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.engine.Engine;
import com.beyonity.matchinggame.engine.ScreenController;
import com.beyonity.matchinggame.engine.ScreenController.Screen;
import com.beyonity.matchinggame.events.EventBus;
import com.beyonity.matchinggame.events.ui.BackGameEvent;
import com.beyonity.matchinggame.ui.PopupManager;
import com.beyonity.matchinggame.utils.Utils;

import com.beyonity.matchinggame.utils.unityAdLisener;
import com.google.android.gms.ads.MobileAds;
import com.unity3d.ads.UnityAds;

public class MainActivity extends FragmentActivity {

	private ImageView mBackgroundImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MobileAds.initialize(this, "ca-app-pub-7987343674758455~6668446139");
		Shared.context = getApplicationContext();
		Shared.engine = Engine.getInstance();
		Shared.eventBus = EventBus.getInstance();
		UnityAds.initialize(this,"1526365",new unityAdLisener());
		setContentView(com.beyonity.matchinggame.R.layout.activity_main);
		mBackgroundImage = (ImageView) findViewById(com.beyonity.matchinggame.R.id.background_image);

		Shared.activity = this;
		Shared.engine.start();
		Shared.engine.setBackgroundImageView(mBackgroundImage);

		// set background
		setBackgroundImage();

		// set menu
		ScreenController.getInstance().openScreen(Screen.MENU);
	}

	@Override
	protected void onDestroy() {
		Shared.engine.stop();
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		if (PopupManager.isShown()) {
			PopupManager.closePopup();
			if (ScreenController.getLastScreen() == Screen.GAME) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		} else if (ScreenController.getInstance().onBack()) {
			super.onBackPressed();
		}
	}

	private void setBackgroundImage() {
		Bitmap bitmap = Utils.scaleDown(com.beyonity.matchinggame.R.drawable.background, Utils.screenWidth(), Utils.screenHeight());
		bitmap = Utils.crop(bitmap, Utils.screenHeight(), Utils.screenWidth());
		bitmap = Utils.downscaleBitmap(bitmap, 2);
		mBackgroundImage.setImageBitmap(bitmap);
	}
}
