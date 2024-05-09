package com.cyk.xiaowang.biz.captureservice.service.impl.camera;

import com.cyk.xiaowang.biz.captureservice.service.camera.AllCamService;
import com.cyk.xiaowang.biz.captureservice.service.impl.BaseCameraServiceImpl;
import com.cyk.xiaowang.biz.captureservice.service.impl.decorator.BaseCameraDecorator;
import org.springframework.stereotype.Service;

/**
 * The class AllCamServiceImpl.
 **/
@Service
public class AllCamServiceImpl extends BaseCameraDecorator implements AllCamService {
    public AllCamServiceImpl(BaseCameraServiceImpl baseCameraService) {
        super(baseCameraService);
    }

    @Override
    public String vendor() {
        return "allCam";
    }
}
