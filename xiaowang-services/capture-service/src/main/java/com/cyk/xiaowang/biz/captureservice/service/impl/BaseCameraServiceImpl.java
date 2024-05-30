package com.cyk.xiaowang.biz.captureservice.service.impl;

import com.cyk.xiaowang.biz.captureservice.domain.dto.HBCamera;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * The class BaseCameraServiceImpl.
 **/
@Component
public class BaseCameraServiceImpl implements CameraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseCameraServiceImpl.class);

    @Override
    public List<File> capture(HBCamera hbCamera, Integer preset) {
        LOGGER.info("do base capture");
        return null;
    }

    @Override
    public boolean rotate(HBCamera hbCamera, Integer preset, Float x, Float y, Float zoom) {
        LOGGER.info("do base rotate");
        return false;
    }

    @Override
    public boolean ptz(HBCamera hbCamera, String command, boolean continuous, Integer speed) {
        LOGGER.info("do base actionPtz");
        return false;
    }
}
