package com.cyk.xiaowang.biz.captureservice.service;

import com.cyk.xiaowang.biz.captureservice.dto.HBCamera;

import java.io.File;
import java.util.List;

/**
 * The interface CameraService.
 **/
public interface CameraService {

    /**
     * 抓图
     *
     * @param hbCamera the hb camera
     * @param preset   the preset
     * @return the list
     */
    List<File> capture(HBCamera hbCamera, Integer preset);

    /**
     * 转动
     *
     * @param hbCamera the hb camera
     * @param preset   the preset
     * @param x        the x
     * @param y        the y
     * @param zoom     the zoom
     * @return the boolean
     */
    boolean rotate(HBCamera hbCamera, Integer preset, Float x, Float y, Float zoom);

    /**
     * 云台控制
     *
     * @param hbCamera   the hb camera
     * @param command    the command
     * @param continuous the continuous
     * @param speed      the speed
     * @return the boolean
     */
    boolean ptz(HBCamera hbCamera, String command, boolean continuous, Integer speed);

    /**
     * Vendor string.
     *
     * @return the string
     */
    default String vendor() {
        return null;
    }
}
