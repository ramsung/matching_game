package com.beyonity.matchinggame.utils;

import android.widget.Toast;

import com.beyonity.matchinggame.common.Memory;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.engine.ScreenController;
import com.beyonity.matchinggame.events.ui.BackGameEvent;
import com.beyonity.matchinggame.ui.PopupManager;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;

/**
 * Created by mohan on 8/29/17.
 */

public class unityAdLisener implements IUnityAdsListener{

	@Override
	public void onUnityAdsReady(String s) {

	}

	@Override
	public void onUnityAdsStart(String s) {

	}

	@Override
	public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {
		if(finishState == UnityAds.FinishState.SKIPPED){
			Toast.makeText(Shared.context, "Ad skipped", Toast.LENGTH_SHORT).show();
		}if(finishState == UnityAds.FinishState.COMPLETED){
			Memory.saveUnlock(Memory.getCurrentID());
			Toast.makeText(Shared.context, "Successfully Unlocked", Toast.LENGTH_SHORT).show();
		}
		if (PopupManager.isShown()) {
			PopupManager.closePopup();
			if (ScreenController.getLastScreen() == ScreenController.Screen.THEME_SELECT) {
				Shared.eventBus.notify(new BackGameEvent());
			}
		}
	}

	@Override
	public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

	}
}