package com.cyk.xiaowang.biz.captureservice.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The class CameraServiceFactory.
 **/
@Component
public class CameraServiceFactory implements InitializingBean, ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    private final Map<String, CameraService> cameraServiceMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        CONTEXT.getBeansOfType(CameraService.class)
                .forEach((key, value) -> {
                    if (value.vendor() != null) {
                        cameraServiceMap.put(value.vendor(), value);
                    }
                });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    /**
     * Choose camera service.
     *
     * @param vendor the vendor
     * @return the camera service
     */
    public CameraService choose(String vendor) {
        return Optional.ofNullable(cameraServiceMap.get(vendor))
                .orElseThrow(() -> new RuntimeException("no such vendor"));
    }
}
