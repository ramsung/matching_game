package com.beyonity.matchinggame.events.ui;

import com.beyonity.matchinggame.events.AbstractEvent;
import com.beyonity.matchinggame.events.EventObserver;
import com.beyonity.matchinggame.themes.Theme;

public class ThemeSelectedEvent extends AbstractEvent {

	public static final String TYPE = ThemeSelectedEvent.class.getName();
	public final Theme theme;

	public ThemeSelectedEvent(Theme theme) {
		this.theme = theme;
	}

	@Override
	protected void fire(EventObserver eventObserver) {
		eventObserver.onEvent(this);
	}

	@Override
	public String getType() {
		return TYPE;
	}

}
