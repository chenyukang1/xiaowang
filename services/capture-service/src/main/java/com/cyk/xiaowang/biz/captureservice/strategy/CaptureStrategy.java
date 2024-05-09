package com.cyk.xiaowang.biz.captureservice.strategy;

import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The class CaptureStrategy.
 **/
@Component
public class CaptureStrategy implements CameraStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaptureStrategy.class);

    @Override
    public void execute(String camId, CameraService cameraService) {
        LOGGER.info("do pre step with camId {}", camId);
        cameraService.capture(null, null);
        LOGGER.info("do post step with camId {}", camId);
    }

    @Override
    public String command() {
        return "capture";
    }
}
