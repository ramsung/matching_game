package com.beyonity.matchinggame.fragments;

import android.support.v4.app.Fragment;

import com.beyonity.matchinggame.events.EventObserver;
import com.beyonity.matchinggame.events.engine.FlipDownCardsEvent;
import com.beyonity.matchinggame.events.engine.GameWonEvent;
import com.beyonity.matchinggame.events.engine.HidePairCardsEvent;
import com.beyonity.matchinggame.events.ui.BackGameEvent;
import com.beyonity.matchinggame.events.ui.FlipCardEvent;
import com.beyonity.matchinggame.events.ui.NextGameEvent;
import com.beyonity.matchinggame.events.ui.ResetBackgroundEvent;
import com.beyonity.matchinggame.events.ui.ThemeSelectedEvent;
import com.beyonity.matchinggame.events.ui.DifficultySelectedEvent;
import com.beyonity.matchinggame.events.ui.StartEvent;

public class BaseFragment extends Fragment implements EventObserver {

	@Override
	public void onEvent(FlipCardEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(DifficultySelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(HidePairCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(FlipDownCardsEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(StartEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ThemeSelectedEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(GameWonEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(BackGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(NextGameEvent event) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void onEvent(ResetBackgroundEvent event) {
		throw new UnsupportedOperationException();
	}

}
