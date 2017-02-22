package com.gpstrace.dlrc.activity;

import java.util.ArrayList;
import java.util.List;

import com.gpstrace.dlrc.R;
import com.gpstrace.dlrc.adapter.SchooleNoticeAdapter;
import com.gpstrace.dlrc.base.ActivityBase;
import com.gpstrace.dlrc.listener.OnNewsListener;
import com.gpstrace.dlrc.model.TResponseBase;
import com.gpstrace.dlrc.model.TResponseNoticeListData;
import com.gpstrace.dlrc.view.WaterfallListView;
import com.gpstrace.dlrc.view.WaterfallListView.IWaterfallListViewListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends ActivityBase implements
		IWaterfallListViewListener{
	// region fields
	private int MAX_MAP_PAGE = 7;
	private String[] mapTitleArr;
	private List<List<TResponseBase>> mapItemLists;
	
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
		
		mapItemLists = new ArrayList<List<TResponseBase>>();
		
		//1
		String[] mapItem1 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_1);
		List<TResponseBase> TResponseBase1 = new ArrayList<TResponseBase>();
		TResponseBase1.add(new TResponseBase(R.drawable.a11, mapItem1[0], true));
		TResponseBase1.add(new TResponseBase(R.drawable.a12, mapItem1[1], true));
		TResponseBase1.add(new TResponseBase(R.drawable.a13, mapItem1[2], true));
		TResponseBase1.add(new TResponseBase(R.drawable.a14, mapItem1[3], true));
		TResponseBase1.add(new TResponseBase(R.drawable.a15, mapItem1[4], true));
		mapItemLists.add(TResponseBase1); 
		
		//2
		String[] mapItem2 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_2);
		List<TResponseBase> TResponseBase2 = new ArrayList<TResponseBase>();
		TResponseBase2.add(new TResponseBase(R.drawable.a21, mapItem2[0], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a22, mapItem2[1], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a23, mapItem2[2], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a24, mapItem2[3], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a25, mapItem2[4], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a26, mapItem2[5], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a27, mapItem2[6], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a28, mapItem2[7], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a29, mapItem2[8], true));
		TResponseBase2.add(new TResponseBase(R.drawable.a210, mapItem2[9], true));
		mapItemLists.add(TResponseBase2);
		
		//3
		String[] mapItem3 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_3);
		List<TResponseBase> TResponseBase3 = new ArrayList<TResponseBase>();
		TResponseBase3.add(new TResponseBase(R.drawable.a31, mapItem3[0], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a32, mapItem3[1], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a33, mapItem3[2], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a34, mapItem3[3], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a35, mapItem3[4], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a36, mapItem3[5], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a37, mapItem3[6], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a38, mapItem3[7], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a39, mapItem3[8], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a310, mapItem3[9], true));
		TResponseBase3.add(new TResponseBase(R.drawable.a311, mapItem3[10], true));
		mapItemLists.add(TResponseBase3);
		
		//4
		String[] mapItem4 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_4);
		List<TResponseBase> TResponseBase4 = new ArrayList<TResponseBase>();
		TResponseBase4.add(new TResponseBase(R.drawable.a41, mapItem4[0], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a42, mapItem4[1], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a44, mapItem4[2], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a44, mapItem4[4], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a45, mapItem4[4], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a46, mapItem4[5], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a47, mapItem4[6], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a48, mapItem4[7], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a49, mapItem4[8], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a410, mapItem4[9], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a411, mapItem4[10], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a412, mapItem4[8], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a413, mapItem4[9], true));
		TResponseBase4.add(new TResponseBase(R.drawable.a414, mapItem4[10], true));
		mapItemLists.add(TResponseBase4);
		
		//5
		String[] mapItem5 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_5);
		List<TResponseBase> TResponseBase5 = new ArrayList<TResponseBase>();
		TResponseBase5.add(new TResponseBase(R.drawable.a51, mapItem5[0], true));
		TResponseBase5.add(new TResponseBase(R.drawable.a52, mapItem5[1], true));
		TResponseBase5.add(new TResponseBase(R.drawable.a53, mapItem5[2], true));
		TResponseBase5.add(new TResponseBase(R.drawable.a54, mapItem5[3], true));
		TResponseBase5.add(new TResponseBase(R.drawable.a55, mapItem5[4], true));
		mapItemLists.add(TResponseBase5);
		
		//6
		String[] mapItem6 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_6);
		List<TResponseBase> TResponseBase6 = new ArrayList<TResponseBase>();
		TResponseBase6.add(new TResponseBase(R.drawable.a61, mapItem6[0], true));
		mapItemLists.add(TResponseBase6);
		
		//7
		String[] mapItem7 = getApplicationContext().getResources()
				.getStringArray(R.array.map_stypes_7);
		List<TResponseBase> TResponseBase7 = new ArrayList<TResponseBase>();
		TResponseBase7.add(new TResponseBase(R.drawable.a71, mapItem7[0], true));
		TResponseBase7.add(new TResponseBase(R.drawable.a72, mapItem7[1], true));
		TResponseBase7.add(new TResponseBase(R.drawable.a73, mapItem7[2], true));
		TResponseBase7.add(new TResponseBase(R.drawable.a74, mapItem7[3], true));
		mapItemLists.add(TResponseBase7);
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
		
		//1.
		RelativeLayout maprl = (RelativeLayout)tipView.findViewById(R.id.map_type_title_rl);
		maprl.setOnClickListener(mClickListener);
		maprl.setTag(i);
		
		//2.初始化标题
		TextView title = (TextView)tipView.findViewById(R.id.map_type_tv);
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
		}
	};
	
	OnClickListener mClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch ((Integer)v.getTag()) {
			case 0:
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				break;
			}
		}
	};
}
