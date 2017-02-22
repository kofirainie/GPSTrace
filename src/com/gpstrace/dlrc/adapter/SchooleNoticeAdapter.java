package com.gpstrace.dlrc.adapter;

import java.util.List;

import com.gpstrace.dlrc.R;
import com.gpstrace.dlrc.listener.OnNewsListener;
import com.gpstrace.dlrc.model.TResponseNoticeListData;
import com.gpstrace.dlrc.provider.Utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @咨询适配器
 * @author YunZ
 * 
 */
public class SchooleNoticeAdapter extends BaseAdapter
{
	// region

	private LayoutInflater mInflater;
	private int mItemResource;
	private Context mContext;
	private int maxItemHeight;
	private List<TResponseNoticeListData> mItems;

	private OnNewsListener mOnNewsListener;
	private String transmitedStr;
	private String untransmit;
	private ColorStateList blueColor;
	private ColorStateList blackColor;	

	// endregion

	// region class

	private class ViewHolder
	{
		TextView noticeTitle;
		TextView noticeScheme;
		TextView noticeTime;
		RelativeLayout noticeLayout;
	}

	// endregion

	/**
	 * @构造函数
	 * @param context
	 * @param data
	 * @param resource
	 */
	public SchooleNoticeAdapter(Context context, List<TResponseNoticeListData> data,
			int resource)
	{
		this.mContext = context;
		this.mInflater = LayoutInflater.from(context);
		this.mItemResource = resource;
		this.mItems = data;
		this.maxItemHeight = getItemHeight();
		transmitedStr = mContext.getResources()
        		.getString(R.string.notice_content_transmited_tip);
		untransmit = mContext.getResources()
        		.getString(R.string.notice_content_untransmit_tip);	     
		this.blueColor = ColorStateList.valueOf(0xFF45BCE3);
	    this.blackColor = ColorStateList.valueOf(0xFF000000);
	}

	// region override

	@Override
	public int getCount()
	{
		if (mItems == null)
		{
			return 0;
		}

		return mItems.size();
	}

	@Override
	public Object getItem(int position)
	{
		if (position < 0 || position >= mItems.size())
		{
			return null;
		}
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(mItemResource, null);
//			viewHolder.noticeTitle = (TextView) convertView
//					.findViewById(R.id.waterfall_schoole_notice_item_tv_title);
//			viewHolder.noticeScheme = (TextView) convertView
//					.findViewById(R.id.waterfall_schoole_notice_item_tv_copy_scheme);
//			viewHolder.noticeTime = (TextView) convertView
//					.findViewById(R.id.waterfall_schoole_notice_item_tv_time);
//			viewHolder.noticeLayout = (RelativeLayout) convertView
//					.findViewById(R.id.waterfall_schoole_notice_item_rlyt_content);
			RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) viewHolder
					.noticeLayout.getLayoutParams();
			params.height = maxItemHeight;
			viewHolder.noticeLayout.setLayoutParams(params);

			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

		final TResponseNoticeListData notice = mItems.get(position);
		final int mPosition = position;

		viewHolder.noticeLayout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (null != mOnNewsListener)
				{
					mOnNewsListener.onOpenNews(v, mPosition, notice);
				}

			}
		});	 
		
		//设置标题字体
		if (notice.getIs_send()) {
	        viewHolder.noticeTitle.setText(Utils.setTextsSameStyle(transmitedStr, 
	        		notice.getTitle(), mContext, 15.f, blackColor));
		} else {
	        viewHolder.noticeTitle.setText(Utils.setTextDiffColorStyle(untransmit,
	        		notice.getTitle(), mContext, 15.f, blueColor, blackColor));
		}		
		viewHolder.noticeScheme.setText(notice.getDocument_no());
		viewHolder.noticeTime.setText(notice.getSend_time());

		return convertView;
	}

	// endregion

	// region methods

	/**
	 * @获取item的高度
	 * @return
	 */
	private int getItemHeight()
	{
		int titleHeight = Utils.dip2px(mContext, Utils.getFontHeight(14));
		int schemeHeight = Utils.dip2px(mContext, Utils.getFontHeight(10));
		int timeHeight = Utils.dip2px(mContext, Utils.getFontHeight(10));
		int otherpadding = Utils.dip2px(mContext, 1f);

		return titleHeight + schemeHeight + timeHeight + otherpadding;
	}

	/**
	 * @添加最新数据
	 * @param datas
	 */
	public void addItemLast(List<TResponseNoticeListData> datas){
		for (int i = 0; i < datas.size(); i++){
			boolean isExist = false;
			for (TResponseNoticeListData newModel : mItems){
				if (newModel.getCode().equals(datas.get(i).getCode())){
					isExist = true;
					break;
				}
			}
			if (!isExist){
				mItems.add(datas.get(i));
			}
		}		
	}
	
	public int getmItemsSize(){
		return mItems.size();
	}

	/**
	 * @设置门店打开界面
	 * @门店就是街友圈
	 * @param listener
	 */
	public void setOnNewsListener(OnNewsListener listener)
	{
		this.mOnNewsListener = listener;
	}

	// endregion

}
