package com.cyk.xiaowang.biz.captureservice.service.impl;

import com.cyk.xiaowang.biz.captureservice.req.AgentCameraReq;
import com.cyk.xiaowang.biz.captureservice.service.CameraService;
import com.cyk.xiaowang.biz.captureservice.service.CameraServiceFactory;
import com.cyk.xiaowang.biz.captureservice.service.EntryService;
import com.cyk.xiaowang.biz.captureservice.strategy.CameraStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The class EntryServiceImpl.
 **/
@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {

    private final CameraServiceFactory cameraServiceFactory;
    private final CameraStrategyFactory cameraStrategyFactory;

    @Override
    public void agentCamera(AgentCameraReq agentCameraReq) {
        CameraService cameraService = cameraServiceFactory.choose(agentCameraReq.getVendor());
        cameraStrategyFactory.choose(agentCameraReq.getCommand()).execute(agentCameraReq.getCamId(), cameraService);
    }
}
