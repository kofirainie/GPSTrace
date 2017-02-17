package com.maptest.lmq.dlrc.activity;

import com.maptest.lmq.dlrc.R;
import com.maptest.lmq.dlrc.base.ActivityBase;
import com.maptest.lmq.dlrc.view.WaterfallListView;
import com.maptest.lmq.dlrc.view.WaterfallListView.IWaterfallListViewListener;

import android.view.View;


public class MainActivity extends ActivityBase implements
		IWaterfallListViewListener{
	// region fields
	private int MAX_MAP_PAGE = 3;
	private String[] mapTitleArr;
	
	
	private WaterfallListView mWaterfallView;
	// endregion
	
	@Override
	public void onRefresh() {
	}

	@Override
	public void onLoadMore() {
	}

	@Override
	public void onScroll(int scrollY) {
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void init() {
		setContentView(R.layout.activity_main_layout);
		super.init();
		
		initBaseData();
		setHeader();
		setMapview();
	}
	
	/**
	 * 初始化基本数据
	 * */
	private void initBaseData(){
		mapTitleArr = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_title);
	}
	
	/**
	 * @初始化activity顶部Header 
	 */
	private void setHeader(){
		mFirstHeader.setVisibility(View.VISIBLE);
		
		mFirstTvTitle.setVisibility(View.VISIBLE);
		mFirstTvTitle.setText(R.string.app_name);
		
		mFirstTvBack.setText("");	
	}
	
	/**
	 * @function 设置地图页面
	 * */
	private void setMapview(){
		mWaterfallView = (WaterfallListView) findViewById(R.id.main_list_view);
		mWaterfallView.setPullLoadEnable(true);
		mWaterfallView.setWaterfallListViewListener(this, 0);
		
		for(int i = 0; i < MAX_MAP_PAGE; i++){
			setMapTypeTipView();
		}
	}

	/**
	 * @function 区分不同的地图板块
	 * */
	private void setMapTypeTipView(){
		
	}
}
