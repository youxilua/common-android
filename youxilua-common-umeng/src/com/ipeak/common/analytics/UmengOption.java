package com.ipeak.common.analytics;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.UmengOnlineConfigureListener;

/**
 * @author youxiachai
 * @date 2012-9-19上午11:01:26
 */
public class UmengOption {
	
	
	/**调试模式默认为true
	 * 
	 */
	public boolean isDebug = true;
	/**
	 * 设置是否允许收集地理位置信息 （默认true）
	 */
	public boolean isAutoLocation = true;
	/**
	 *  设置是否打开页面路径访问功能（默认打开）
	 */
	public boolean isDurationtrack = true;
	protected boolean isOnlineConfig;
	/**
	 * 默认10分钟 60 * 10 *1000;
	 */
	public long sessionMillis = 600000;

	/**
	 * ReportPolicy.BATCH_AT_LAUNCH; ReportPolicy.DAILY; ReportPolicy.REALTIME;
	 * ReportPolicy.WIFIONLY
	 * 
	 * @param ctx
	 * @param policy
	 */
	public int policy;
	protected Context ctx;
	/**
	 * 注意此接口只在在线参数有变化的时候才会回调，实现此接接口：
	 */
	public UmengOnlineConfigureListener onlineConfigureListener;

	public UmengOption(Context ctx, boolean isOnlineConfig) {
		init(ctx, isOnlineConfig, null);
	}

	public UmengOption(Context ctx, UmengOnlineConfigureListener listener) {
		init(ctx, true, listener);
	}

	private void init(Context ctx, boolean isOnlineConfig,
			UmengOnlineConfigureListener listener) {
		if (listener != null) {
			this.isOnlineConfig = true;
			this.onlineConfigureListener = listener;
		} else {
			this.ctx = ctx;
			this.isOnlineConfig = isOnlineConfig;
		}
	}

	public void setDefaultReportPolicy(Context ctx, int policy) {
		MobclickAgent.setDefaultReportPolicy(ctx, policy);
	}

}
