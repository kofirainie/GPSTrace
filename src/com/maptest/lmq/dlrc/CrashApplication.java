package com.maptest.lmq.dlrc;

import com.maptest.lmq.dlrc.handler.LoadHandler;

import android.app.Application;

/**
 * @应用程序类
 * @author kofirainie
 */
public class CrashApplication extends Application
{
	@Override
	public void onCreate()
	{
		try
		{
			Class.forName("android.os.AsyncTask");
		} catch (Throwable ignore)
		{
		}

		super.onCreate();
		this.start();
	}

	/**
	 * @搴旂敤绋嬪簭鍚姩绫伙紝鍦ㄨ鏂规硶涓姞杞藉簲鐢ㄧ▼搴忛厤缃�
	 */
	private void start()
	{
		LoadHandler.getInstance().Load(getApplicationContext());
	}
}
