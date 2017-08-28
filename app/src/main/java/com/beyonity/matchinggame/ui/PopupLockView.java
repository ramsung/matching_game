package com.beyonity.matchinggame.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beyonity.matchinggame.R;
import com.beyonity.matchinggame.common.Music;
import com.beyonity.matchinggame.common.Shared;
import com.beyonity.matchinggame.utils.FontLoader;
import com.beyonity.matchinggame.utils.FontLoader.Font;

public class PopupLockView extends LinearLayout {



	public PopupLockView(Context context) {
		this(context, null);
	}

	public PopupLockView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
		setBackgroundResource(R.drawable.lvl_unlock_popup);
		LayoutInflater.from(getContext()).inflate(R.layout.popup_unlock_view, this, true);

		TextView rateView = (TextView) findViewById(R.id.rate_text);
		FontLoader.setTypeface(context, new TextView[] { rateView }, Font.MandroidBB);





	}






}
