common-android
==============

#友盟 for android 操作的封装包#

* 介绍
* 详解

##介绍##
这个库,把友盟的初始化设置,自定义事件,还有使用时长进行了一层简单的封装,例如,初始化设置

`UmengOption option = new UmengOption(this, true);
UmengAnalytics.initUmengOption(option);`

如果需要个别设置只需要在init之前,对option,直接

`option.isDebug = false`

##详解##
封装的类:
友盟的设置对象:UmengOption

友盟的自定义事件:UmengEvent

`UmengEvent ue = new UmengEventUmengEvent(Context ctx,eventId,label);

UmengAnalytics.customEvent(ue);

如果是带map的,在调用customEvent之前,使用即可

ue.setEventMap(eventMap)
`

友盟的自定义事件中的时长统计:UmengTimeLine

`UmengTimeLine useTime =  new UmengTimeLine(this, "id","label");

开始:UmengAnalytics.reportUseTime(useTime.isBegin())

结束: :UmengAnalytics.reportUseTime(useTime.isEnd);`

这样的好处就是我们只需要维护好对象就行了


地址: [https://github.com/youxilua/common-android](https://github.com/youxilua/common-android "github地址")