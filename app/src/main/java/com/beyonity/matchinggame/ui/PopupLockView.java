package com.beyonity.matchinggame.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.common.Music;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.utils.FontLoader;
import com.beyonity.matchinggame.utils.FontLoader.Font;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class PopupLockView extends LinearLayout implements IUnityAdsListener{
	@Override
	public void onUnityAdsReady(String s) {

	}

	@Override
	public void onUnityAdsStart(String s) {

	}

	@Override
	public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

	}

	@Override
	public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

	}

	public PopupLockView(Context context) {
		this(context, null);
	}

	public PopupLockView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundResource(R.drawable.lvl_unlock_popup);
		LayoutInflater.from(getContext()).inflate(R.layout.popup_unlock_view, this, true);
		Button adButton = (Button) findViewById(R.id.adButton);
		FontLoader.setTypeface(context, new TextView[] { adButton }, Font.MandroidBB);
		adButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(UnityAds.isReady()){
					if(PopupManager.isShown()){
						PopupManager.closePopup();
					}
					UnityAds.show(Shared.activity);
				}else {
					Toast.makeText(Shared.context, "Ad is not loaded try again later", Toast.LENGTH_SHORT).show();
				}
			}
		});


	}






}
