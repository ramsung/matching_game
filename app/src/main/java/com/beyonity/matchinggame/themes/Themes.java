package com.beyonity.matchinggame.themes;

import android.graphics.Bitmap;

import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.utils.Utils;

import java.util.ArrayList;

public class Themes {

	public static String URI_DRAWABLE = "drawable://";

	public static Theme createAnimalsTheme() {
		Theme theme = new Theme();
		theme.id = 1;
		theme.name = "Animals";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_animals";
		theme.tileImageUrls = new ArrayList<String>();
		// 40 drawables
		for (int i = 1; i <= 28; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("animals_%d", i));
		}
		return theme;
	}

	public static Theme createMosterTheme() {
		Theme theme = new Theme();
		theme.id = 2;
		theme.name = "Mosters";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_horror";
		theme.tileImageUrls = new ArrayList<String>();
		// 40 drawables
		for (int i = 1; i <= 40; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("mosters_%d", i));
		}
		return theme;
	}

	public static Theme createEmojiTheme() {
		Theme theme = new Theme();
		theme.id = 3;
		theme.name = "Emoji";
		theme.backgroundImageUrl = URI_DRAWABLE + "background";
		theme.tileImageUrls = new ArrayList<String>();
		// 40 drawables
		for (int i = 1; i <= 40; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("emoji_%d", i));
		}
		return theme;
	}
	
	public static Bitmap getBackgroundImage(Theme theme) {
		String drawableResourceName = theme.backgroundImageUrl.substring(Themes.URI_DRAWABLE.length());
		int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
		Bitmap bitmap = Utils.scaleDown(drawableResourceId, Utils.screenWidth(), Utils.screenHeight());
		return bitmap;
	}

	public static Theme createFlagTheme() {
		Theme theme = new Theme();
		theme.id = 4;
		theme.name = "Flag";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_city";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 36; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("flag_%d", i));
		}
		return theme;
	}

	public static Theme createFoodTheme() {
		Theme theme = new Theme();
		theme.id = 5;
		theme.name = "Food";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_food";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 56; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("food_%d", i));
		}
		return theme;
	}

}
