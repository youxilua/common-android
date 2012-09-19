package com.ipeak.common.analytics;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

/**
 * @author youxiachai
 * @date 2012-9-19上午11:49:27
 */
public class UmengEvent {
	
	public Context ctx;
	public String eventId;
	public String label;
	
	
	public Map<String, String> eventMap;
	
	public UmengEvent(Context ctx,String eventId,String label){
		init(ctx,eventId,label);
	}
	
	private void init(Context ctx,String eventId,String label){
		this.ctx = ctx;
		this.eventId = eventId;
		this.label = label;
	}
	
	public UmengEvent setEventMap(HashMap<String, String> eventMap){
		this.eventMap = eventMap;
		return this;
	}
	

}
