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


	public static Theme createCompTheme() {
		Theme theme = new Theme();
		theme.id = 12;
		theme.name = "Comp";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_comp";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("comp_%d", i));
		}
		return theme;
	}

	public static Theme createConstructTheme() {
		Theme theme = new Theme();
		theme.id = 13;
		theme.name = "Construct";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_construct";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("construct_%d", i));
		}
		return theme;
	}

	public static Theme createEduTheme() {
		Theme theme = new Theme();
		theme.id = 14;
		theme.name = "Edu";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_edu";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("edu_%d", i));
		}
		return theme;
	}

	public static Theme createElcTheme() {
		Theme theme = new Theme();
		theme.id = 15;
		theme.name = "Elc";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_elc";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("elc_%d", i));
		}
		return theme;
	}

	public static Theme createEntertainTheme() {
		Theme theme = new Theme();
		theme.id = 16;
		theme.name = "Entertain";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_Entertain";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("entertain_%d", i));
		}
		return theme;
	}
	public static Theme createFarmTheme() {
		Theme theme = new Theme();
		theme.id = 17;
		theme.name = "Farm";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_farm";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("farm_%d", i));
		}
		return theme;
	}
	public static Theme createFurnTheme() {
		Theme theme = new Theme();
		theme.id = 18;
		theme.name = "Furn";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_furn";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("furn_%d", i));
		}
		return theme;
	}
	public static Theme createGestTheme() {
		Theme theme = new Theme();
		theme.id = 19;
		theme.name = "Gest";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_gest";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("gest_%d", i));
		}
		return theme;
	}

	public static Theme createHobbTheme() {
		Theme theme = new Theme();
		theme.id = 20;
		theme.name = "Hobb";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_hobb";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("hobb_%d", i));
		}
		return theme;
	}

	public static Theme createKidsTheme() {
		Theme theme = new Theme();
		theme.id = 21;
		theme.name = "Kids";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_kids";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("kids_%d", i));
		}
		return theme;
	}
	public static Theme createMedTheme() {
		Theme theme = new Theme();
		theme.id = 22;
		theme.name = "Med";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_med";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("med_%d", i));
		}
		return theme;
	}

	public static Theme createMonuTheme() {
		Theme theme = new Theme();
		theme.id = 23;
		theme.name = "Monu";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_monu";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("monu_%d", i));
		}
		return theme;
	}


	public static Theme createSportTheme() {
		Theme theme = new Theme();
		theme.id = 24;
		theme.name = "Sport";
		theme.backgroundImageUrl = URI_DRAWABLE + "back_sport";
		theme.tileImageUrls = new ArrayList<String>();
		// 36 drawables
		for (int i = 1; i <= 24; i++) {
			theme.tileImageUrls.add(URI_DRAWABLE + String.format("sport_%d", i));
		}
		return theme;
	}

}
