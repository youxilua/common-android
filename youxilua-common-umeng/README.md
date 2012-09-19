#友盟分析需要的权限
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.READ_PHONE_STATE"></uses-permission>
<uses-permission android:name="android.permission.READ_LOGS"></uses-permission>


<manifest……>
<application ……>
    ……
<activity ……/>
<meta-data android:value="YOUR_APP_KEY" android:name="UMENG_APPKEY"></meta-data>
<meta-data android:value="Channel ID" android:name="UMENG_CHANNEL"/>
</application>
<uses-sdk android:minSdkVersion="4"></uses-sdk>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"></uses-permission>
<uses-permission android:name="android.permission.INTERNET"></uses-permission>
<uses-permission android:name="android.permission.READ_PHONE_STATE"></uses-permission>
<uses-permission android:name="android.permission.READ_LOGS"></uses-permission>
</manifest>


#
META-DATA 	用途
UMENG_APPKEY 	用来定位该应用程序的唯一性。
UMENG_CHANNEL 	用来标注应用推广渠道，区分新用户的来源来查看统计，您可以使用20位以内的英文和数字为渠道定名，替换value中的"Channel ID"。详见渠道统计。
权限 	用途
INTERNET(必须) 	允许应用程序联网，以便向我们的服务器端发送数据。
READ_PHONE_STATE(必须) 	获取用户手机的IMEI，用来唯一的标识用户。(如果您的应用会运行在无法读取IMEI的平板上，我们会将mac地址作为用户的唯一标识，请添加权限： android.permission.ACCESS_WIFI_STATE )
ACCESS_NETWORK_STATE 	检测网络状态，友盟SDK 1.6版本新增权限。
READ_LOGS 	如果您想获得客户端crash的报告, 需要添加这个权限。具体见【使用错误报告】。
WRITE_EXTERNAL_STORAGE 	如果您使用了友盟自动更新提醒功能，需添加这个权限，为了将更新的APK临时存在SD卡里。