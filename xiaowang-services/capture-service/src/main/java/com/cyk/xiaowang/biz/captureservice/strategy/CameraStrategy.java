package com.cyk.xiaowang.biz.captureservice.strategy;

import com.cyk.xiaowang.biz.captureservice.service.CameraService;

/**
 * The class CameraStrategy.
 **/
public interface CameraStrategy {

    void execute(String camId, CameraService cameraService);

    default String command() {
        return null;
    }
}
