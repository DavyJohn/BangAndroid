package com.saint.ibangandroid.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by yyx on 16/3/1.
 */
public class DeviceUtil {

    /**
     * 设备类型
     */
    public static final String DEVICE_TYPE = "android";

    /**
     * 获取设备串号 唯一
     * @param context
     * @return
     */
    public static String getDevice(Context context){
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = tm.getSimSerialNumber();
        return imei;
    }
}
