package com.ipeak.common.autoupdate.umeng;

import android.content.Context;

import com.umeng.update.UmengDownloadListener;
import com.umeng.update.UmengUpdateAgent;
import com.umeng.update.UmengUpdateListener;
import com.umeng.update.UpdateResponse;

public class UmengUpdate {

	/**
	 * 有更新弹出对话框,而且只在wifi下进行检查更新
	 * 
	 * @param mContext
	 */
	public static void autoUpdate(final Context mContext) {
		autoUpdate(mContext, null, null, true);
	}
	
	public static void showUpdateDialog(final Context ctx,UpdateResponse updateInfo){
		   UmengUpdateAgent.showUpdateDialog(ctx, updateInfo);
	}
	
	/**
	 * @param mContext
	 * @param updateListener
	 */
	public static void autoUpdate(final Context mContext, UmengUpdateListener updateListener) {
		autoUpdate(mContext, updateListener, null, false);
	}

	/**
	 * 设置是否支持在非WIFI模式下进行更新
	 * 
	 * @param mContext
	 * @param isWifiOnly
	 */
	public static void autoUpdate(final Context mContext, boolean isWifiOnly) {
		autoUpdate(mContext, null, null, isWifiOnly);
	}

	/**
	 * 自动升级的所有设置
	 * 
	 * @param mContext
	 * @param updateListener
	 *            更新的回调监听
	 * @param downloadListener
	 *            处理下载回调接口
	 *            对于自动更新的下载接口，同样可以注册回调消息，这样在自动更新下载APK结束或者失败的时候，可以使用该接口来做出相应的反映
	 *            ，以提供 更友好的用户体验。
	 * @param isWifiOnly
	 */
	public static void autoUpdate(final Context mContext,
			UmengUpdateListener updateListener,
			UmengDownloadListener downloadListener, boolean isWifiOnly) {
		// 设置是否在wifi模式下进行更新
		if (isWifiOnly) {
			UmengUpdateAgent.setUpdateOnlyWifi(true);
		} else {
			UmengUpdateAgent.setUpdateOnlyWifi(false);
		}
		// 进行自动更新检测
		UmengUpdateAgent.update(mContext);

		// 处理更新回调的接口
		if (updateListener != null) {
			UmengUpdateAgent.setUpdateAutoPopup(false);
			UmengUpdateAgent.setUpdateListener(updateListener);
		}

		// 处理下载回调的接口
		if (downloadListener != null) {
			UmengUpdateAgent.setOnDownloadListener(downloadListener);
		}

	}
	/**
	 * 更新回调接口写法模板 new UmengUpdateListener() {
	 * 
	 * @Override public void onUpdateReturned(int updateStatus,UpdateResponse
	 *           updateInfo) { switch (updateStatus) { case 0: // has update
	 *           UmengUpdateAgent.showUpdateDialog(mContext, updateInfo); break;
	 *           case 1: // has no update Toast.makeText(mContext, "没有更新",
	 *           Toast.LENGTH_SHORT) .show(); break; case 2: // none wifi
	 *           Toast.makeText(mContext, "没有wifi连接， 只在wifi下更新",
	 *           Toast.LENGTH_SHORT) .show(); break; case 3: // time out
	 *           Toast.makeText(mContext, "超时", Toast.LENGTH_SHORT) .show();
	 *           break; } }
	 * 
	 *           下载回调接口写法模板 new UmengDownloadListener(){
	 * @Override public void OnDownloadEnd(int result) {
	 *           Toast.makeText(mContext, "download result : " + result ,
	 *           Toast.LENGTH_SHORT).show(); } }
	 */

}
