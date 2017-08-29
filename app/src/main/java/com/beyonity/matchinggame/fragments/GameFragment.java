package com.beyonity.matchinggame.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.events.engine.FlipDownCardsEvent;
import com.beyonity.matchinggame.events.engine.GameWonEvent;
import com.beyonity.matchinggame.events.engine.HidePairCardsEvent;
import com.beyonity.matchinggame.model.Game;
import com.beyonity.matchinggame.ui.BoardView;
import com.beyonity.matchinggame.ui.PopupManager;
import com.beyonity.matchinggame.utils.Clock;
import com.beyonity.matchinggame.utils.Clock.OnTimerCount;
import com.beyonity.matchinggame.utils.FontLoader;
import com.beyonity.matchinggame.utils.FontLoader.Font;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;

public class GameFragment extends BaseFragment {

	private BoardView mBoardView;
	private TextView mTime;
	private ImageView mTimeImage;
	private LinearLayout ads;
	InterstitialAd mInterstitialAd;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ViewGroup view = (ViewGroup) inflater.inflate(R.layout.game_fragment, container, false);
		view.setClipChildren(false);
		((ViewGroup)view.findViewById(R.id.game_board)).setClipChildren(false);
		//ad
		mInterstitialAd = new InterstitialAd(Shared.context);
		mInterstitialAd.setAdUnitId("ca-app-pub-7987343674758455/5160935102");
		mInterstitialAd.loadAd(new AdRequest.Builder().build());


		mInterstitialAd.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				// Code to be executed when an ad finishes loading.
				Log.i("Ads", "onAdLoaded");
			}

			@Override
			public void onAdFailedToLoad(int errorCode) {
				// Code to be executed when an ad request fails.
				Log.i("Ads", "onAdFailedToLoad");
			}

			@Override
			public void onAdOpened() {
				// Code to be executed when the ad is displayed.
				Log.i("Ads", "onAdOpened");
			}

			@Override
			public void onAdLeftApplication() {
				// Code to be executed when the user has left the app.
				Log.i("Ads", "onAdLeftApplication");
			}

			@Override
			public void onAdClosed() {
				// Code to be executed when when the interstitial ad is closed.
				mInterstitialAd.loadAd(new AdRequest.Builder().build());
				Log.i("Ads", "onAdClosed");
			}
		});
		mTime = (TextView) view.findViewById(R.id.time_bar_text);
		mTimeImage = (ImageView) view.findViewById(R.id.time_bar_image);
		FontLoader.setTypeface(Shared.context, new TextView[] {mTime}, Font.MandroidBB);
		mBoardView = BoardView.fromXml(getActivity().getApplicationContext(), view);
		FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.game_container);
		frameLayout.addView(mBoardView);
		frameLayout.setClipChildren(false);
		AdView mAdView = (AdView) view.findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);



		// build board
		buildBoard();
		Shared.eventBus.listen(FlipDownCardsEvent.TYPE, this);
		Shared.eventBus.listen(HidePairCardsEvent.TYPE, this);
		Shared.eventBus.listen(GameWonEvent.TYPE, this);
		
		return view;
	}
	
	@Override
	public void onDestroy() {
		Shared.eventBus.unlisten(FlipDownCardsEvent.TYPE, this);
		Shared.eventBus.unlisten(HidePairCardsEvent.TYPE, this);
		Shared.eventBus.unlisten(GameWonEvent.TYPE, this);
		super.onDestroy();
	}

	private void buildBoard() {
		Game game = Shared.engine.getActiveGame();
		int time = game.boardConfiguration.time;
		setTime(time);
		mBoardView.setBoard(game);
		
		startClock(time);
	}
	
	private void setTime(int time) {
		int min = time / 60;
		int sec = time - min*60;
		mTime.setText(" " + String.format("%02d", min) + ":" + String.format("%02d", sec));
	}

	private void startClock(int sec) {
		Clock clock = Clock.getInstance();
		clock.startTimer(sec*1000, 1000, new OnTimerCount() {
			
			@Override
			public void onTick(long millisUntilFinished) {
				setTime((int) (millisUntilFinished/1000));
			}
			
			@Override
			public void onFinish() {
				setTime(0);
			}
		});
	}

	@Override
	public void onEvent(GameWonEvent event) {
		mTime.setVisibility(View.GONE);
		mTimeImage.setVisibility(View.GONE);
		PopupManager.showPopupWon(event.gameState,mInterstitialAd);
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		mBoardView.flipDownAll();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		mBoardView.hideCards(event.id1, event.id2);
	}

}
