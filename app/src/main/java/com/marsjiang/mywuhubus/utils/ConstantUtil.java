package com.marsjiang.mywuhubus.utils;

import android.Manifest;

/**
 * Created by Jiang on 2016/9/2.
 */
public interface ConstantUtil {
    public static final int FORRESULT = 100;
    //------------------------------------------------------------地址------------------------------------------------------//
    public static final String baseUrl = "http://220.180.139.42:8980/SmartBusServer/Main";
    //--------------------------------------------------------------权限-------------------------------------------------------//
    /**
     * 位置信息权限请求标志
     */
    public static final int QUEST_CODE_LOCTION = 1;
    /**
     * 发送短信权限请求标志
     */
    public static final int QUEST_CODE_SEND_SMS = 2;
    /**
     * 摄像头权限标志
     */
    public static final int QUEST_CODE_CAMERA = 3;
    /**
     * 批量请求权限
     */
    public static final int QUEST_CODE_ALL = 4;
    /**
     * 拨打电话权限
     */
    public static final int QUEST_CODE_CALL_PHONE = 5;
    //要申请的权限
    public static final String[] permArray =
            {Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.SEND_SMS, Manifest.permission.CAMERA,
                    Manifest.permission.CALL_PHONE};
}
