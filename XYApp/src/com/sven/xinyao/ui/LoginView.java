package com.sven.xinyao.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.sven.xinyao.ui.R;

public class LoginView extends HttpSupportActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_view);
		ViewUtils.inject(this);
	}

	@OnClick(R.id.btnBack)
	@Override
	public void back(View v) {
		super.back(v);
	}

	@OnClick(R.id.reg)
	public void Reg(View v) {
		TurnActivity(RegView.class, false);
	}

	@OnClick(R.id.forget)
	public void Forget(View v) {
		TurnActivity(UpdataPasswordView.class, false);
	}
}
