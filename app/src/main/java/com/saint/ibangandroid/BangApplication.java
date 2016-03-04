package com.saint.ibangandroid;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.util.ArrayList;


/**
 * Created by yyx on 16/2/24.
 */
public final class BangApplication extends Application {

    private Context appContext;
    /**
     * Activity集合
     */
    private static ArrayList<BangBaseActivity> activitys = new ArrayList<BangBaseActivity>();

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
//        JPushInterface.setDebugMode(Constant.SystemConstant.ISDEBUG);
//        JPushInterface.init(appContext);
//        CrashReport.initCrashReport(appContext, "900008946", false);
    }

    public Context getAppContext() {
        return appContext;
    }

    /**
     * 添加Activity到ArrayList<Activity>管理集合
     *
     * @param activity
     */
    public void addActivity(BangBaseActivity activity) {
        String className = activity.getClass().getName();
        for (Activity at : activitys) {
            if (className.equals(at.getClass().getName())) {
                activitys.remove(at);
                break;
            }
        }
        activitys.add(activity);
    }

    /**
     * 退出应用程序的时候，手动调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        for (BangBaseActivity activity : activitys) {
            activity.defaultFinish();
        }
    }

}
