package com.cyk.xiaowang.biz.captureservice.strategy;

import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The class PTZStrategy.
 **/
@Component
public class PTZStrategy implements CameraStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(PTZStrategy.class);

    @Override
    public void execute(String camId, CameraService cameraService) {
        LOGGER.info("do pre step with camId {}", camId);
        cameraService.ptz(null, null, false, null);
        LOGGER.info("do post step with camId {}", camId);
    }

    @Override
    public String command() {
        return "ptz";
    }
}
