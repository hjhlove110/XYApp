package com.sven.xinyao.ui;

import com.sven.xinyao.ui.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainUi extends TabActivity {
	private static String TAB_MENU1 = "tab3";
	private static String TAB_MENU2 = "tab2";
	private static String TAB_MENU3 = "tab1";
	private RadioGroup rg;
	private TabHost tabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_ui);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		initTabWidget();
	}

	private void initTabWidget() {
		tabs = this.getTabHost();
		TabSpec spec;
		//
		spec = tabs.newTabSpec(TAB_MENU1).setIndicator(TAB_MENU1);
		spec.setContent(new Intent(this, Tab3.class));
		tabs.addTab(spec);
		//
		spec = tabs.newTabSpec(TAB_MENU2).setIndicator(TAB_MENU2);
		spec.setContent(new Intent(this, Tab2.class));
		tabs.addTab(spec);
		//
		spec = tabs.newTabSpec(TAB_MENU3).setIndicator(TAB_MENU3);
		spec.setContent(new Intent(this, Tab1.class));
		tabs.addTab(spec);
		
		tabs.setCurrentTab(0);
		this.rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int idx = -1;
				if (checkedId == R.id.radio0) {
					idx = 0;
				} else if (checkedId == R.id.radio1) {
					idx = 1;
				} else if (checkedId == R.id.radio2) {
					idx = 2;
				}
				switchActivity(idx);
			}
		});
	}

	protected void switchActivity(int idx) {
		tabs.setCurrentTab(idx);
		RadioButton rb = (RadioButton) rg.getChildAt(idx);
		rb.setChecked(true);
	}
}
