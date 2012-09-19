package com.ipeak.common.shared.umeng;

import com.umeng.api.sns.UMSnsService;

import android.content.Context;
import android.content.Intent;

public class Shared {

	public static void simpleShared(Context ctx){
		UMSnsService.share(ctx, "",null);
	}
	
	public static Intent createShareIntent() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Shared from the ActionBar widget.");
        return Intent.createChooser(intent, "Share");
    }
}
