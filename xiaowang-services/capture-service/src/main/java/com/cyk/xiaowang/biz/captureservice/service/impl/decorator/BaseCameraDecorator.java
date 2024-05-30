package com.cyk.xiaowang.biz.captureservice.service.impl.decorator;

import com.cyk.xiaowang.biz.captureservice.domain.dto.HBCamera;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;

import java.io.File;
import java.util.List;

/**
 * The class BaseCameraDecorator.
 **/
public abstract class BaseCameraDecorator implements CameraService {

    private final CameraService wrapper;

    public BaseCameraDecorator(CameraService cameraService) {
        this.wrapper = cameraService;
    }

    @Override
    public List<File> capture(HBCamera hbCamera, Integer preset) {
        return wrapper.capture(hbCamera, preset);
    }

    @Override
    public boolean rotate(HBCamera hbCamera, Integer preset, Float x, Float y, Float zoom) {
        return wrapper.rotate(hbCamera, preset,x ,y,zoom);
    }

    @Override
    public boolean ptz(HBCamera hbCamera, String command, boolean continuous, Integer speed) {
        return wrapper.ptz(hbCamera, command, continuous, speed);
    }
}
