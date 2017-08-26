package com.beyonity.matchinggame.fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.common.Memory;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.events.ui.ThemeSelectedEvent;
import com.beyonity.matchinggame.themes.Theme;
import com.beyonity.matchinggame.themes.Themes;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class themeFragment extends Fragment
{
    private static final String ARG_C = "content";
    public static themeFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C,content);
        themeFragment fragment = new themeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        String content = getArguments().getString(ARG_C);
        View first = inflater.inflate(R.layout.first8, container, false);
        View second = inflater.inflate(R.layout.second8, container, false);
        View third = inflater.inflate(R.layout.third8, container, false);
        View fourth = inflater.inflate(R.layout.fourth8, container, false);

        if(Integer.parseInt(content) == 0){
                setFirstPage(first);

            return first;
        }else if (Integer.parseInt(content) == 1){
	        setSecondPage(second);
	        NativeExpressAdView adView = (NativeExpressAdView)second.findViewById(R.id.adView);

	        AdRequest request = new AdRequest.Builder().build();
	        adView.loadAd(request);


            return second;
        }else if (Integer.parseInt(content) == 2){
            return third;
        }

        return fourth;

    }


    private void setFirstPage(View view){
        //themes
		View animals = view.findViewById(R.id.theme_animals_container);
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
		animateShow(fruits);

    }
	private void setSecondPage(View view){
		View drinks = view.findViewById(R.id.theme_drinks_container);
		View comm = view.findViewById(R.id.theme_comm_container);
		View commerce = view.findViewById(R.id.theme_commerce_container);
		final Theme themeDrinks = Themes.createDrinksTheme();
		setStars((ImageView) drinks.findViewById(R.id.theme_drinks), themeDrinks, "drinks");
		final Theme themeComm= Themes.createCommTheme();
		setStars((ImageView) comm.findViewById(R.id.theme_comm), themeComm, "comm");
		final Theme themeCommerce = Themes.createCommerceTheme();
		setStars((ImageView) commerce.findViewById(R.id.theme_commerce), themeCommerce, "commerce");
		drinks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeDrinks));
			}
		});
		comm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeComm));
			}
		});
		commerce.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeCommerce));
			}
		});

		animateShow(drinks);
		animateShow(comm);
		animateShow(commerce);

	}

    private void animateShow(View view) {
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1f);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(animatorScaleX, animatorScaleY);
        animatorSet.setInterpolator(new DecelerateInterpolator(2));
        view.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        animatorSet.start();
    }

    private void setStars(ImageView imageView, Theme theme, String type) {
        int sum = 0;
        for (int difficulty = 1; difficulty <= 6; difficulty++) {
            sum += Memory.getHighStars(theme.id, difficulty);
        }
        int num = sum / 6;
        if (num != 0) {
            String drawableResourceName = String.format(Locale.US, type + "_theme_star_%d", num);
            int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
            imageView.setImageResource(drawableResourceId);
        }
    }

}
