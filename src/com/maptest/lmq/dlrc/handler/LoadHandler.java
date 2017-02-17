package com.maptest.lmq.dlrc.handler;

import com.maptest.lmq.dlrc.config.AppConfig;
import com.maptest.lmq.dlrc.provider.CacheHelper;
import com.maptest.lmq.dlrc.provider.HttpProvider;

import android.content.Context;

/**
 * @初始加载类
 * @author kofirainie
 */
public class LoadHandler
{
	// region field

	private static LoadHandler sInstance;

	// endregion

	/**
	 * @单件方法
	 * @return
	 */
	public static LoadHandler getInstance()
	{
		if (sInstance == null)
		{
			sInstance = new LoadHandler();
		}
		return sInstance;
	}
	
	/**
	 * @加载方法
	 * @param context
	 */
	public void Load(Context context)
	{
		AppConfig.getInstance().init();
		CrashHandler.getInstance().init(context);
		AppHandler.getInstance().setContext(context);
		AppHandler.getInstance().setImageLoader();				
		HttpProvider.setAgentString(AppHandler.getInstance().getAgentString(
				context));
		CacheHelper.getInstance().setContext(context);
		AppHandler.getInstance().initUmengConfig();
	}
}
