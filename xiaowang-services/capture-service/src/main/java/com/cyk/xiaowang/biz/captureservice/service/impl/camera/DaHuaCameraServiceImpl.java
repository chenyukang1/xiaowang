package com.cyk.xiaowang.biz.captureservice.service.impl.camera;

import com.cyk.xiaowang.biz.captureservice.domain.dto.HBCamera;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import com.cyk.xiaowang.biz.captureservice.service.camera.DaHuaService;
import com.cyk.xiaowang.biz.captureservice.service.impl.BaseCameraServiceImpl;
import com.cyk.xiaowang.biz.captureservice.service.impl.decorator.RTMPCameraDecorator;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * The class DaHuaCameraServiceImpl.
 **/
@Service
public class DaHuaCameraServiceImpl implements DaHuaService {

    private final CameraService delegate;

    public DaHuaCameraServiceImpl(BaseCameraServiceImpl baseCameraService) {
        // 装饰链组合
        this.delegate = new RTMPCameraDecorator(baseCameraService);
    }

    @Override
    public List<File> capture(HBCamera hbCamera, Integer preset) {
        return delegate.capture(hbCamera, preset);
    }

    @Override
    public boolean rotate(HBCamera hbCamera, Integer preset, Float x, Float y, Float zoom) {
        return delegate.rotate(hbCamera, preset, x, y, zoom);
    }

    @Override
    public boolean ptz(HBCamera hbCamera, String command, boolean continuous, Integer speed) {
        return delegate.ptz(hbCamera, command, continuous, speed);
    }

    @Override
    public String vendor() {
        return "daHua";
    }
}
