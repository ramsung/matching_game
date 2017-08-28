package com.beyonity.matchinggame.fragments;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.renderscript.Script;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.common.GetThemeScore;
import com.beyonity.matchinggame.common.Memory;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.events.ui.ThemeSelectedEvent;
import com.beyonity.matchinggame.themes.Theme;
import com.beyonity.matchinggame.themes.Themes;
import com.beyonity.matchinggame.ui.PopupManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class themeFragment extends Fragment{
	private static final String ARG_C = "content";
	private static final String TAG = "themeFragment";
	Theme themeAnimals;
	Theme themeMonsters;
	Theme themeEmoji;
	Theme themeTrans;
	Theme themeFlag;
	Theme themeFood;
	Theme themeVeg;
	Theme themeFruits;
	Theme themeDrinks;
	Theme themeComm;
	Theme themeCommerce;
	Theme themeComputer;
	Theme themeConstruction;
	Theme themeEducation;
	Theme themeElectronics;
	Theme themeEntertainment;
	Theme themeFarming;
	Theme themeFurniture;
	Theme themeGesture;
	Theme themeHobbies;
	Theme themeKids;
	Theme themeMedical;
	Theme themeMonuments;
	Theme themeSports;




	View first,second,third;
	int id;

	public static themeFragment newInstance(String content) {
		Bundle args = new Bundle();
		args.putString(ARG_C, content);
		themeFragment fragment = new themeFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		String content = getArguments().getString(ARG_C);
		first = inflater.inflate(R.layout.first8, container, false);
		second = inflater.inflate(R.layout.second8, container, false);
		third = inflater.inflate(R.layout.third8, container, false);
		//View fourth = inflater.inflate(R.layout.fourth8, container, false);

		if (Integer.parseInt(content) == 0) {
			setFirstPage(first);

			return first;
		} else if (Integer.parseInt(content) == 1) {
			setSecondPage(second);


			return second;
		} else {
			setThirdPage(third);
			return third;
		}


	}


	private void setFirstPage(View view) {
		//themes
		View animals = view.findViewById(R.id.theme_animals_container);
		View monsters = view.findViewById(R.id.theme_monsters_container);
		View emoji = view.findViewById(R.id.theme_emoji_container);
		View trans = view.findViewById(R.id.theme_trans_container);
		View flag = view.findViewById(R.id.theme_flag_container);
		View food = view.findViewById(R.id.theme_food_container);
		View veg = view.findViewById(R.id.theme_veg_container);
		View fruits = view.findViewById(R.id.theme_fruits_container);

		themeAnimals = Themes.createAnimalsTheme();
		setStars((ImageView) animals.findViewById(R.id.theme_animals), themeAnimals, "animals");
		animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Shared.eventBus.notify(new ThemeSelectedEvent(themeAnimals));
			}
		});
		animateShow(animals);

		if (GetThemeScore.getScore(themeAnimals.id) >= 2 || Memory.getUnlock(2)) {
			themeMonsters = Themes.createMosterTheme();
			setStars((ImageView) monsters.findViewById(R.id.theme_monsters), themeMonsters, "monsters");
			monsters.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeMonsters));
				}
			});
			animateShow(monsters);
		} else {
			themeMonsters = Themes.createMosterTheme();
			Log.i(TAG, "setFirstPage: inside else");
			monsters.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeMonsters.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if (GetThemeScore.getScore(themeMonsters.id) >= 2 || Memory.getUnlock(3)) {
			themeEmoji = Themes.createEmojiTheme();
			setStars((ImageView) emoji.findViewById(R.id.theme_emoji), themeEmoji, "emoji");
			emoji.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeEmoji));
				}
			});
			animateShow(emoji);
		} else {
			themeEmoji = Themes.createEmojiTheme();
			Log.i(TAG, "setFirstPage: inside else");
			emoji.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeEmoji.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}

		if (GetThemeScore.getScore(themeEmoji.id) == 2|| Memory.getUnlock(4)) {
			themeTrans = Themes.createTransTheme();
			setStars((ImageView) trans.findViewById(R.id.theme_trans), themeEmoji, "trans");
			trans.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeTrans));
				}
			});
			animateShow(trans);
		} else {
			themeTrans= Themes.createTransTheme();
			Log.i(TAG, "setFirstPage: inside else");
			trans.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeTrans.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if (GetThemeScore.getScore(themeTrans.id) == 3 || Memory.getUnlock(5)) {
			themeFlag = Themes.createFlagTheme();
			setStars((ImageView) flag.findViewById(R.id.theme_flag), themeFlag, "flag");
			flag.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeFlag));
				}
			});
			animateShow(flag);
		}else {
			themeFlag = Themes.createFlagTheme();
			Log.i(TAG, "setFirstPage: inside else");
			flag.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeFlag.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}



		if (GetThemeScore.getScore(themeFlag.id) == 2|| Memory.getUnlock(6)) {
			themeFood = Themes.createFoodTheme();
			setStars((ImageView) food.findViewById(R.id.theme_food), themeFood, "food");
			food.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeFood));
				}
			});
			animateShow(food);
		} else {
			themeFood = Themes.createFoodTheme();
			Log.i(TAG, "setFirstPage: inside else");
			food.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeFood.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if (GetThemeScore.getScore(themeFood.id) == 2|| Memory.getUnlock(7)) {
			themeVeg = Themes.createVegTheme();
			setStars((ImageView) veg.findViewById(R.id.theme_veg), themeFood, "veg");
			veg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeVeg));
				}
			});
			animateShow(veg);
		} else {
			themeVeg= Themes.createVegTheme();
			Log.i(TAG, "setFirstPage: inside else");
			veg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeVeg.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if (GetThemeScore.getScore(themeVeg.id) == 2|| Memory.getUnlock(8)) {
			themeFruits = Themes.createFruitsTheme();
			setStars((ImageView) fruits.findViewById(R.id.theme_fruits), themeFood, "fruits");
			fruits.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeFruits));
				}
			});
			animateShow(fruits);
		}else {
			themeFruits= Themes.createFruitsTheme();
			Log.i(TAG, "setFirstPage: inside else");
			fruits.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeFruits.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 1));
		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 2));
		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 3));
		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 4));
		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 5));
		Log.i(TAG, "setFirstPage: " + Memory.getHighStars(themeAnimals.id, 6));


	}

	private void setSecondPage(View view) {
		View drinks = view.findViewById(R.id.theme_drinks_container);
		View comm = view.findViewById(R.id.theme_comm_container);
		View commerce = view.findViewById(R.id.theme_commerce_container);
		View computer = view.findViewById(R.id.theme_comp_container);
		View construction = view.findViewById(R.id.theme_construct_container);
		View education = view.findViewById(R.id.theme_edu_container);
		View electronics = view.findViewById(R.id.theme_elec_container);
		View entertainment = view.findViewById(R.id.theme_entertain_container);

		if(GetThemeScore.getScore(8)>=2|| Memory.getUnlock(9)){
			themeDrinks = Themes.createDrinksTheme();
			setStars((ImageView) drinks.findViewById(R.id.theme_drinks), themeDrinks, "drinks");
			drinks.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeDrinks));
				}
			});
			animateShow(drinks);
		}else {
			themeDrinks= Themes.createDrinksTheme();
			Log.i(TAG, "setFirstPage: inside else");
			drinks.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeDrinks.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(9)>=2|| Memory.getUnlock(10)) {
			themeComm = Themes.createCommTheme();
			setStars((ImageView) comm.findViewById(R.id.theme_comm), themeComm, "comm");
			comm.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeComm));
				}
			});
			animateShow(comm);
		}else {
			themeComm = Themes.createCommTheme();
			Log.i(TAG, "setFirstPage: inside else");
			comm.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeComm.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(10)>=2|| Memory.getUnlock(11)) {
			themeCommerce = Themes.createCommerceTheme();
			setStars((ImageView) commerce.findViewById(R.id.theme_commerce), themeCommerce, "commerce");
			commerce.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeCommerce));
				}
			});
			animateShow(commerce);
		}else {
			themeCommerce= Themes.createCommerceTheme();
			Log.i(TAG, "setFirstPage: inside else");
			commerce.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeCommerce.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(11)>=2|| Memory.getUnlock(12)) {
			themeComputer = Themes.createCompTheme();
			setStars((ImageView) computer.findViewById(R.id.theme_comp), themeComputer, "comp");
			computer.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeComputer));
				}
			});
			animateShow(computer);
		}else {
			themeComputer= Themes.createCompTheme();
			Log.i(TAG, "setFirstPage: inside else");
			computer.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeComputer.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(12)>=2|| Memory.getUnlock(13)) {
			themeConstruction = Themes.createConstructTheme();
			setStars((ImageView) construction.findViewById(R.id.theme_construct), themeConstruction, "construct");
			construction.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeConstruction));
				}
			});
			animateShow(construction);
		}else {
			themeConstruction = Themes.createConstructTheme();
			Log.i(TAG, "setFirstPage: inside else");
			construction.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeConstruction.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(13)>=2|| Memory.getUnlock(14)) {
			themeEducation = Themes.createEduTheme();
			setStars((ImageView) education.findViewById(R.id.theme_edu), themeEducation, "edu");

			education.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeEducation));
				}
			});
			animateShow(education);
		}else {
			themeEducation = Themes.createEduTheme();
			Log.i(TAG, "setFirstPage: inside else");
			education.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeEducation.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(14)>=2|| Memory.getUnlock(15)) {
			themeElectronics = Themes.createElcTheme();
			setStars((ImageView) electronics.findViewById(R.id.theme_elec), themeElectronics, "elec");
			electronics.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeElectronics));
				}
			});
			animateShow(electronics);
		}else {
			themeElectronics = Themes.createElcTheme();
			Log.i(TAG, "setFirstPage: inside else");
			electronics.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeElectronics.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(15)>=2|| Memory.getUnlock(16)) {
			themeEntertainment = Themes.createEntertainTheme();
			setStars((ImageView) entertainment.findViewById(R.id.theme_entertain), themeEntertainment, "entertain");
			entertainment.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeEntertainment));
				}
			});
			animateShow(entertainment);
		}else {
			themeEntertainment = Themes.createEntertainTheme();
			Log.i(TAG, "setFirstPage: inside else");
			entertainment.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeEntertainment.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}










	}

	private void setThirdPage(View view) {
		View farming = view.findViewById(R.id.theme_farm_container);
		View furniture = view.findViewById(R.id.theme_furn_container);
		View gestures = view.findViewById(R.id.theme_gest_container);
		View hobbies = view.findViewById(R.id.theme_hobb_container);
		View kids = view.findViewById(R.id.theme_kid_container);
		View medical = view.findViewById(R.id.theme_med_container);
		View monuments = view.findViewById(R.id.theme_monu_container);
		View sports = view.findViewById(R.id.theme_sport_container);

		if(GetThemeScore.getScore(16)>=2|| Memory.getUnlock(17)){
			themeFarming = Themes.createFarmTheme();
			setStars((ImageView) farming.findViewById(R.id.theme_farm), themeFarming, "farm");
			farming.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeFarming));
				}
			});
			animateShow(farming);
		}else {
			themeFarming = Themes.createFarmTheme();
			Log.i(TAG, "setFirstPage: inside else");
			farming.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeFarming.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(17)>=2|| Memory.getUnlock(18)) {
			themeFurniture = Themes.createFurnTheme();
			setStars((ImageView) furniture.findViewById(R.id.theme_furn), themeFurniture, "frun");
			furniture.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeFurniture));
				}
			});
			animateShow(furniture);
		}else {
			themeFurniture= Themes.createFurnTheme();
			Log.i(TAG, "setFirstPage: inside else");
			furniture.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeFurniture.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(18)>=2|| Memory.getUnlock(19)) {
			themeGesture= Themes.createGestTheme();
			setStars((ImageView) gestures.findViewById(R.id.theme_gest), themeGesture, "gest");
			gestures.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeGesture));
				}
			});
			animateShow(gestures);
		}else {
			themeGesture= Themes.createGestTheme();
			Log.i(TAG, "setFirstPage: inside else");
			gestures.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeGesture.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}



		if(GetThemeScore.getScore(19)>=2|| Memory.getUnlock(20)) {
			themeHobbies = Themes.createHobbTheme();
			setStars((ImageView) hobbies.findViewById(R.id.theme_hobb), themeHobbies, "hobb");
			hobbies.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeHobbies));
				}
			});
			animateShow(hobbies);
		}else {
			themeHobbies= Themes.createHobbTheme();
			Log.i(TAG, "setFirstPage: inside else");
			hobbies.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeHobbies.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(20)>=2|| Memory.getUnlock(21)) {
			themeKids = Themes.createKidsTheme();
			setStars((ImageView) kids.findViewById(R.id.theme_kid), themeKids, "kids");
			kids.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeKids));
				}
			});
			animateShow(kids);
		}else {
			themeKids = Themes.createKidsTheme();
			Log.i(TAG, "setFirstPage: inside else");
			kids.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeKids.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(21)>=2|| Memory.getUnlock(22)) {
			themeMedical = Themes.createMedTheme();
			setStars((ImageView) medical.findViewById(R.id.theme_med), themeMedical, "med");
			medical.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeMedical));
				}
			});
			animateShow(medical);
		}else {
			themeMedical= Themes.createMedTheme();
			Log.i(TAG, "setFirstPage: inside else");
			medical.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeMedical.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(22)>=2|| Memory.getUnlock(23)) {
			themeMonuments = Themes.createMonuTheme();
			setStars((ImageView) monuments.findViewById(R.id.theme_monu), themeMonuments, "monu");
			monuments.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeMonuments));
				}
			});
			animateShow(monuments);
		}else {
			themeMonuments= Themes.createMonuTheme();
			Log.i(TAG, "setFirstPage: inside else");
			monuments.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeMonuments.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}


		if(GetThemeScore.getScore(23)>=2|| Memory.getUnlock(4)) {
			themeSports = Themes.createSportTheme();
			setStars((ImageView) sports.findViewById(R.id.theme_sport), themeSports, "sport");
			sports.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Shared.eventBus.notify(new ThemeSelectedEvent(themeSports));
				}
			});
			animateShow(sports);
		}else {
			themeSports = Themes.createSportTheme();
			Log.i(TAG, "setFirstPage: inside else");
			sports.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Memory.saveCurrentID(themeSports.id);
					PopupManager.showPopupUnlock();
					/*if(UnityAds.isReady()){
						UnityAds.show(getActivity());
					}*/
				}
			});


		}

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

			String drawableResourceName = String.format(Locale.US, type + "_theme_star_%d", num);
			int drawableResourceId = Shared.context.getResources().getIdentifier(drawableResourceName, "drawable", Shared.context.getPackageName());
			imageView.setImageResource(drawableResourceId);

	}


	@Override
	public void onResume() {
		super.onResume();
		String content = getArguments().getString(ARG_C);
		if(Integer.parseInt(content)==0){
			setFirstPage(first);
		}
	}
}
