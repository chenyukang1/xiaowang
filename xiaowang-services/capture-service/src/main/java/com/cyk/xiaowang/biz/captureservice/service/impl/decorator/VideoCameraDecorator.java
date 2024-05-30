package com.cyk.xiaowang.biz.captureservice.service.impl.decorator;

import com.cyk.xiaowang.biz.captureservice.domain.dto.HBCamera;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * The class VideoCameraDecorator.
 **/
public class VideoCameraDecorator extends BaseCameraDecorator {

    private static final Logger LOGGER = LoggerFactory.getLogger(VideoCameraDecorator.class);

    public VideoCameraDecorator(CameraService cameraService) {
        super(cameraService);
    }

    @Override
    public List<File> capture(HBCamera hbCamera, Integer preset) {
        List<File> files = super.capture(hbCamera, preset);
        // video camera 增强抓图的能力
        LOGGER.info("video start record");
        return files;
    }
}
