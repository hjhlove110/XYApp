package com.sven.xinyao.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class RegView extends HttpSupportActivity {
	@ViewInject(R.id.title)
	private TextView title;
	@ViewInject(R.id.reback)
	private Button reback;
	@ViewInject(R.id.btnReg)
	private Button btnReg;

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reg_view);
		context = this;
		ViewUtils.inject(this);
		initViews();
	}

	private void initViews() {
		title.setText("зЂВс");
	}

	@OnClick({ R.id.btnBack, R.id.reback })
	@Override
	public void back(View v) {
		super.back(v);
	}
}
