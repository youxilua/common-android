package com.ipeak.common.analytics;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

/**
 * @author youxiachai
 * @date 2012-9-19上午11:17:24
 * event_id 为当前统计的事件ID,注意要先在友盟网站上注册此事件ID
	ekvFlag 事件标示符,ekvFlag 和 event_id 一起标示一个唯一事件，并不会被统计；对于同一个事件
，在onKVEventBegin和onKVEventEnd 中要传递相同的event_id 和 flag
 */
public class UmengTimeLine {
	
	protected boolean isBegin = true;
	public Context ctx;
	public String eventId;
	public String ekvFlag;
	public String label;
	public Map<String,String> kVMap;
	
	//...晚些时候实现duration的设置
	
	public UmengTimeLine(Context ctx,String eventId, String label){
		init(ctx,eventId, label);
	}
	
	public void setMapEvent(HashMap<String, String> eventMap,String flag){
		this.kVMap = eventMap;
		this.ekvFlag = flag;
	}
	
	private void init(Context ctx,String eventId,String label){
		this.ctx = ctx;
		this.eventId = eventId;
		this.label = label;
	}
	
	public UmengTimeLine isBegin(){
		this.isBegin = true;
		return this;
	}
	
	public UmengTimeLine isEnd(){
		this.isBegin = false;
		return this;
	}

}
