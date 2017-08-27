package com.beyonity.matchinggame.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.adapter.ThemePagerAdapter;
import com.beyonity.matchinggame.common.Memory;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.events.ui.ThemeSelectedEvent;
import com.beyonity.matchinggame.themes.Theme;
import com.beyonity.matchinggame.themes.Themes;

import java.util.Locale;

public class ThemeSelectFragment extends Fragment {
	ViewPager viewPager;
	ImageView dots;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(Shared.context).inflate(R.layout.fragment_theme, container, false);
		//themes
		/*View animals = view.findViewById(R.id.theme_animals_container);
		View monsters = view.findViewById(R.id.theme_monsters_container);
		View emoji = view.findViewById(R.id.theme_emoji_container);
		View trans = view.findViewById(R.id.theme_trans_container);
		View flag = view.findViewById(R.id.theme_flag_container);
		View food = view.findViewById(R.id.theme_food_container);
		View veg = view.findViewById(R.id.theme_veg_container);
		View fruits = view.findViewById(R.id.theme_fruits_container);

		final Theme themeAnimals = Themes.createAnimalsTheme();
		setStars((ImageView) animals.findViewById(R.id.theme_animals), themeAnimals, "animals");
		final Theme themeMonsters = Themes.createMosterTheme();
		setStars((ImageView) monsters.findViewById(R.id.theme_monsters), themeMonsters, "monsters");
		final Theme themeEmoji = Themes.createEmojiTheme();
		setStars((ImageView) emoji.findViewById(R.id.theme_emoji), themeEmoji, "emoji");
		final Theme themeTrans = Themes.createTransTheme();
		setStars((ImageView) trans.findViewById(R.id.theme_trans), themeEmoji, "trans");
		final Theme themeFlag = Themes.createFlagTheme();
		setStars((ImageView) flag.findViewById(R.id.theme_flag), themeFlag, "flag");
		final Theme themeFood = Themes.createFoodTheme();
		setStars((ImageView) food.findViewById(R.id.theme_food), themeFood, "food");
		final Theme themeVeg = Themes.createVegTheme();
		setStars((ImageView) veg.findViewById(R.id.theme_veg), themeFood, "veg");
		final Theme themeFruits = Themes.createFruitsTheme();
		setStars((ImageView) fruits.findViewById(R.id.theme_fruits), themeFood, "fruits");

		animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));
			}
		});

		monsters.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeMonsters));
			}
		});

		emoji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeEmoji));
			}
		});
		trans.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeTrans));
			}
		});

		flag.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeFlag));
			}
		});
		food.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeFood));
			}
		});
		veg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeVeg));
			}
		});
		fruits.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeFruits));
			}
		});


		animateShow(animals);
		animateShow(monsters);
		animateShow(emoji);
		animateShow(trans);

		animateShow(flag);
		animateShow(food);
		animateShow(veg);
		animateShow(fruits);*/
		dots = (ImageView) view.findViewById(R.id.dots);
		viewPager =(ViewPager) view.findViewById(R.id.viewPager);
		viewPager.setAdapter(new ThemePagerAdapter(getChildFragmentManager(),3));
		viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				if(position == 0){

					dots.setImageResource(R.drawable.first);
				}else if(position == 1){

					dots.setImageResource(R.drawable.second);
				}else if(position == 2){

					dots.setImageResource(R.drawable.third);
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});


		return view;
	}


}
