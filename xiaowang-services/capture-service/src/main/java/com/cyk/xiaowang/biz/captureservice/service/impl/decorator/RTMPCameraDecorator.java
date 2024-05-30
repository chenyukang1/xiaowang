package com.cyk.xiaowang.biz.captureservice.service.impl.decorator;

import com.cyk.xiaowang.biz.captureservice.domain.dto.HBCamera;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * The class RTMPCameraDecorator.
 **/
public class RTMPCameraDecorator extends BaseCameraDecorator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RTMPCameraDecorator.class);

    public RTMPCameraDecorator(CameraService cameraService) {
        super(cameraService);
    }

    @Override
    public List<File> capture(HBCamera hbCamera, Integer preset) {
        List<File> files = super.capture(hbCamera, preset);
        // rtmp camera 增强抓图的能力
        LOGGER.info("video start push rtmp stream");
        return files;
    }
}
