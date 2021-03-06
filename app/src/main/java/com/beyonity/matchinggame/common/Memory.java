package com.beyonity.matchinggame.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class Memory {

	private static final String SHARED_PREFERENCES_NAME = "com.beyonity.matchinggame";
	private static String highStartKey = "theme_%d_difficulty_%d";

	public static void save(int theme, int difficulty, int stars) {
		int highStars = getHighStars(theme, difficulty);
		if (stars > highStars) {
			SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
			Editor edit = sharedPreferences.edit();
			String key = String.format(highStartKey, theme, difficulty);
			edit.putInt(key, stars).commit();
		}
	}

	public static int getHighStars(int theme, int difficulty) {
		SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
		String key = String.format(highStartKey, theme, difficulty);
		return sharedPreferences.getInt(key, 0);
	}

	public static void saveUnlock(int id){
		SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
		Editor edit = sharedPreferences.edit();

		edit.putBoolean(String.valueOf(id), true).commit();
	}

	public static boolean getUnlock(int id) {
		SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getBoolean(String.valueOf(id), false);
	}

	public static void saveCurrentID(int id){
		SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
		Editor edit = sharedPreferences.edit();

		edit.putInt("currentID", id).commit();
	}

	public static int getCurrentID() {
		SharedPreferences sharedPreferences = Shared.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
		return sharedPreferences.getInt("currentID", 0);
	}


}
