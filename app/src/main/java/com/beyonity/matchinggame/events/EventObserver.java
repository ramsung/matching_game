package com.beyonity.matchinggame.events;

import com.beyonity.matchinggame.events.engine.FlipDownCardsEvent;
import com.beyonity.matchinggame.events.engine.GameWonEvent;
import com.beyonity.matchinggame.events.engine.HidePairCardsEvent;
import com.beyonity.matchinggame.events.ui.BackGameEvent;
import com.beyonity.matchinggame.events.ui.DifficultySelectedEvent;
import com.beyonity.matchinggame.events.ui.FlipCardEvent;
import com.beyonity.matchinggame.events.ui.NextGameEvent;
import com.beyonity.matchinggame.events.ui.ResetBackgroundEvent;
import com.beyonity.matchinggame.events.ui.StartEvent;
import com.beyonity.matchinggame.events.ui.ThemeSelectedEvent;


public interface EventObserver {

	void onEvent(FlipCardEvent event);

	void onEvent(DifficultySelectedEvent event);

	void onEvent(HidePairCardsEvent event);

	void onEvent(FlipDownCardsEvent event);

	void onEvent(StartEvent event);

	void onEvent(ThemeSelectedEvent event);

	void onEvent(GameWonEvent event);

	void onEvent(BackGameEvent event);

	void onEvent(NextGameEvent event);

	void onEvent(ResetBackgroundEvent event);

}
