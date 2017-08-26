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
	public static Theme createTransTheme() {
		Theme theme = new Theme();
		theme.id = 4;
		theme.name = "Trans";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_trans";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 25; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("trans_%d", i));
		}
		return theme;
	}
	public static Theme createFlagTheme() {
		Theme theme = new Theme();
		theme.id = 5;
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
		theme.id = 6;
		theme.name = "Food";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_food";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 56; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("food_%d", i));
		}
		return theme;
	}
	public static Theme createVegTheme() {
		Theme theme = new Theme();
		theme.id = 7;
		theme.name = "Veg";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_veg";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 21; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("veg_%d", i));
		}
		return theme;
	}
	public static Theme createFruitsTheme() {
		Theme theme = new Theme();
		theme.id = 8;
		theme.name = "Fruits";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_fruits";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 20; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("fruits_%d", i));
		}
		return theme;
	}
	public static Theme createDrinksTheme() {
		Theme theme = new Theme();
		theme.id = 9;
		theme.name = "Drinks";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_drinks";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 27; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("drinks_%d", i));
		}
		return theme;
	}
	public static Theme createCommTheme() {
		Theme theme = new Theme();
		theme.id = 10;
		theme.name = "Comm";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_comm";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 28; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("comm_%d", i));
		}
		return theme;
	}
	public static Theme createCommerceTheme() {
		Theme theme = new Theme();
		theme.id = 11;
		theme.name = "Commerce";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_commerce";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("commerce_%d", i));
		}
		return theme;
	}







}
