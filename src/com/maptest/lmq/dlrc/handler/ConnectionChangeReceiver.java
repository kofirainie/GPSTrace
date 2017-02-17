package com.maptest.lmq.dlrc.handler;

import com.maptest.lmq.dlrc.base.ActivityBase;
import com.maptest.lmq.dlrc.provider.NetworkHelper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @网络监听器
 * @author YunZ
 * 
 */
public class ConnectionChangeReceiver extends BroadcastReceiver
{
	// region fields

	ActivityBase mAcitvity;

	// endregion
	
	//region methods

	/**
	 * @构造函数
	 * @param mActivity
	 */
	public ConnectionChangeReceiver(ActivityBase activity)
	{
		this.mAcitvity = activity;
	}

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Boolean isCon = NetworkHelper.checkConnection(context);

		mAcitvity.changeView(isCon);
	}
	
	//endregion
}
