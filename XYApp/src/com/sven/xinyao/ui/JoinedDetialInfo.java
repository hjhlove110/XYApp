package com.sven.xinyao.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class JoinedDetialInfo extends HttpSupportActivity {
	@ViewInject(R.id.title)
	private TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joined_detial_info);
		ViewUtils.inject(this);
		title.setText("±®√˚œÍ«È");
	}
	
	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}
}
