package com.cyk.xiaowang.biz.captureservice.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The class CameraStrategyContext.
 **/
@Component
public class CameraStrategyFactory implements InitializingBean, ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    private final Map<String, CameraStrategy> strategyMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        CONTEXT.getBeansOfType(CameraStrategy.class)
                .forEach((Key, value) -> strategyMap.put(value.command(), value));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    /**
     * Choose camera strategy.
     *
     * @param command the command
     * @return the camera strategy
     */
    public CameraStrategy choose(String command) {
        return Optional.ofNullable(strategyMap.get(command))
                .orElseThrow(() -> new RuntimeException("no such command"));
    }
}
