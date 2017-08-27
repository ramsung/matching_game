package com.beyonity.matchinggame.common;

import com.beyonity.matchinggame.themes.Theme;

/**
 * Created by mohan on 8/27/17.
 */

public class GetThemeScore {

	public static int getScore(int id){
		int sum = 0;
		for (int difficulty = 1; difficulty <= 6; difficulty++) {
			sum += Memory.getHighStars(id, difficulty);
		}
		return sum / 6;
	}
}
