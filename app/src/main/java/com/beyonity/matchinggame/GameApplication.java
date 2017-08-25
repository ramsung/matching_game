package com.beyonity.matchinggame;

import android.app.Application;

import com.beyonity.matchinggame.utils.FontLoader;

public class GameApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		FontLoader.loadFonts(this);

	}
}
