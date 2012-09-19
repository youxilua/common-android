package com.ipeak.common.feedback.umeng;

import com.umeng.fb.UMFeedbackService;

import android.content.Context;

public class FeedBack {
	
	public static void launch(Context ctx){
		UMFeedbackService.openUmengFeedbackSDK(ctx);
	}
}
