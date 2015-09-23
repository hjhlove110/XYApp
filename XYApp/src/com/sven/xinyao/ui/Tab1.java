package com.sven.xinyao.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class Tab1 extends HttpSupportActivity {
	private String[] titles = new String[] { "加入心药(预报名)", "已报名的临床研究", "患者信息",
			"我的收藏", "我的足迹", "我的消息", "报名流程", "联系我们" };
	private Context context;
	@ViewInject(R.id.btnM1)
	private Button btnM1;
	@ViewInject(R.id.btnM2)
	private Button btnM2;
	@ViewInject(R.id.btnM3)
	private Button btnM3;
	@ViewInject(R.id.btnM4)
	private Button btnM4;
	@ViewInject(R.id.btnM5)
	private Button btnM5;
	@ViewInject(R.id.btnM6)
	private Button btnM6;
	@ViewInject(R.id.btnM7)
	private Button btnM7;
	@ViewInject(R.id.btnM8)
	private Button btnM8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		ViewUtils.inject(this);
		context = this;
		setButton();
	}

	@OnClick(R.id.imgHead)
	public void goLogin(View v) {
		startActivity(new Intent(context, LoginView.class));
	}

	private void setButton() {
		btnM1.setText(titles[0]);
		btnM2.setText(titles[1]);
		btnM3.setText(titles[2]);
		btnM4.setText(titles[3]);
		btnM5.setText(titles[4]);
		btnM6.setText(titles[5]);
		btnM7.setText(titles[6]);
		btnM8.setText(titles[7]);
	}

	@OnClick(R.id.btnM1)
	public void btnM1(View v) {
		TurnActivity(JoinXyView.class, false);
	}

	@OnClick(R.id.btnM2)
	public void btnM2(View v) {
		TurnActivity(JoinedXyView.class, false);
	}

	@OnClick(R.id.btnM3)
	public void btnM3(View v) {
		TurnActivity(PatientInfoView.class, false);
	}

	@OnClick(R.id.btnM4)
	public void btnM4(View v) {
		TurnActivity(MyCollection.class, false);
	}

	@OnClick(R.id.btnM5)
	public void btnM5(View v) {
		TurnActivity(MyFootprint.class, false);
	}

	@OnClick(R.id.btnM6)
	public void btnM6(View v) {
		TurnActivity(JoinXyView.class, false);
	}

	@OnClick(R.id.btnM7)
	public void btnM7(View v) {
		startActivity(new Intent(context, InstructionView.class).putExtra(
				"title", "报名流程"));
	}

	@OnClick(R.id.btnM8)
	public void btnM8(View v) {
		startActivity(new Intent(context, InstructionView.class).putExtra(
				"title", "联系我们"));
	}
}
