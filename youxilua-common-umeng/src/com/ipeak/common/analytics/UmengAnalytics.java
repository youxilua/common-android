package com.ipeak.common.analytics;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * @author youxiachai
 * @date 2012-9-19上午10:52:55
 */
public class UmengAnalytics {
	public static void initUmengOption(UmengOption umengOption){
		if(android.os.Build.VERSION.SDK_INT > 14){
			com.umeng.common.Log.LOG = true;
		}
		MobclickAgent.setDebugMode(umengOption.isDebug);
		MobclickAgent.setAutoLocation(umengOption.isAutoLocation);
		MobclickAgent.setSessionContinueMillis(umengOption.sessionMillis);
		MobclickAgent.openActivityDurationTrack(umengOption.isDurationtrack);
		if(umengOption.isOnlineConfig){
			MobclickAgent.updateOnlineConfig(umengOption.ctx);
			if(umengOption.onlineConfigureListener != null){
				MobclickAgent.setOnlineConfigureListener(umengOption.onlineConfigureListener);
			}
		}
	}

	/**友盟的基本API
	 * @param ctx
	 */
	public static void basicResume(Context ctx){
		MobclickAgent.onResume(ctx);
	}
	
	public static void basicPause(Context ctx){
		MobclickAgent.onPause(ctx);
	}
	
	
	
	
	/**在application 里面调用
	 * @param ctx
	 */
	public static void basicError(Context ctx){
		MobclickAgent.onError(ctx);
	}
	
	/**在try catch里面调用
	 * @param ctx
	 */
	public static void reportError(Context ctx,Exception e){
		MobclickAgent.reportError(ctx, e.getMessage());
	}
	
	/**
	 * 示例：
	 *统计游戏中“死亡"事件发生的关卡数，那么可以在死亡的函数里调用
	 *MobclickAgent.onEvent(this, "player_dead","level");
	 * @param ctx
	 * @param eventid
	 * @param label
	 */
	public static void customEvent(UmengEvent umengEvent){
		if(umengEvent.eventMap != null){
			MobclickAgent.onEvent(umengEvent.ctx, umengEvent.eventId, umengEvent.eventMap);
			return;
		}
		if(umengEvent.label != null){
			MobclickAgent.onEvent(umengEvent.ctx, umengEvent.eventId, umengEvent.label);
		}else{
			MobclickAgent.onEvent(umengEvent.ctx, umengEvent.eventId);
		}
		
	}
	
	public static void reportUseTime(UmengTimeLine options){
		if(options.isBegin){
			setBegin(options);
		}else{
			setEnd(options);
		}
	}
	
	private static void setBegin(UmengTimeLine options){
		if(options.kVMap != null){
			MobclickAgent.onKVEventBegin(options.ctx, options.eventId, options.kVMap, options.ekvFlag);
		}else{
			if(options.label != null){
				MobclickAgent.onEventBegin(options.ctx, options.eventId, options.label);
			}else{
				MobclickAgent.onEventBegin(options.ctx, options.eventId);
			}
		}
	}
	
	private static void setEnd(UmengTimeLine options){
		if(options.kVMap != null){
			MobclickAgent.onKVEventEnd(options.ctx, options.eventId, options.ekvFlag);
		}else{
			if(options.label != null){
				MobclickAgent.onEventEnd(options.ctx, options.eventId, options.label);
			}else{
				MobclickAgent.onEventEnd(options.ctx, options.eventId);
			}
		}
	}
	

}
