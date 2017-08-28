package com.beyonity.matchinggame.common;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.beyonity.matchinggame.engine.Engine;
import com.beyonity.matchinggame.events.EventBus;
import com.unity3d.ads.UnityAds;

public class Shared {

	public static Context context;
	public static FragmentActivity activity; // it's fine for this app, but better move to weak reference
	public static Engine engine;
	public static EventBus eventBus;
	public static UnityAds unityAds;

}
