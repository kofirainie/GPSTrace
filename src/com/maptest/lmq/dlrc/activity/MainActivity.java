package com.maptest.lmq.dlrc.activity;

import java.util.ArrayList;
import java.util.List;

import com.maptest.lmq.dlrc.R;
import com.maptest.lmq.dlrc.adapter.SchooleNoticeAdapter;
import com.maptest.lmq.dlrc.base.ActivityBase;
import com.maptest.lmq.dlrc.listener.OnNewsListener;
import com.maptest.lmq.dlrc.model.TResponseNoticeListData;
import com.maptest.lmq.dlrc.view.WaterfallListView;
import com.maptest.lmq.dlrc.view.WaterfallListView.IWaterfallListViewListener;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActivityBase implements
		IWaterfallListViewListener{
	// region fields
	private int MAX_MAP_PAGE = 3;
	private String[] mapTitleArr;
	
	//作废
	private List<TResponseNoticeListData> notices;
	private SchooleNoticeAdapter noticeAdapter;
	
	
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
			setMapTypeTipView(i);
		}
			
		notices = new ArrayList<TResponseNoticeListData>();
		noticeAdapter = new SchooleNoticeAdapter(this, notices, 
				R.layout.waterfall_notice_item_layout);
		noticeAdapter.setOnNewsListener(mOnNoticeListener);
		
		mWaterfallView.setAdapter(noticeAdapter);
	}

	/**
	 * @function 区分不同的地图板块
	 * */
	private void setMapTypeTipView(int i){
		View tipView = LayoutInflater.from(this).inflate(
				R.layout.map_type_title_layout, null, false);
		
		TextView title = (TextView)tipView.findViewById(R.id.map_type_title_tv);
		if (mapTitleArr.length > 0 && mapTitleArr.length > i) {
			title.setText(String.format(
					getResources().getString(R.string.main_type_tile_srr),
					i + 1, mapTitleArr[i].toString()));
		} else {
			title.setText(getString(R.string.app_name));
		}
		
		mWaterfallView.addHeaderView(tipView, null, false);
	}
	
	/**
	 * @function 学校通知item点击事件
	 */
	OnNewsListener mOnNoticeListener = new OnNewsListener(){
		@Override
		public void onOpenNews(Object item, int position, Object arg){
//			TResponseNoticeListData notice = (TResponseNoticeListData) arg;
		}
	};
}
