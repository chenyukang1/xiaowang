package com.cyk.xiaowang.biz.hb2service.mq;

import com.cyk.xiaowang.biz.hb2service.domain.ReportMessage;
import com.cyk.xiaowang.biz.hb2service.domain.mq.MessageWrapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The class MessageSender.
 **/
@Component
@RequiredArgsConstructor
public class MessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    private final RabbitTemplate template;

    @Value("${hb2.mq.business.exchange:com.cyk.xiaowang.business.exchange}")
    private String exchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        ReportMessage reportMessage = ReportMessage.builder()
                .reporter("chenyk")
                .picUrl("http://1234:2134/a.msg")
                .picId(1234L)
                .message("found alarm")
                .build();
        String routingKey = "com.cyk.xiaowang.business.report";
        template.convertAndSend(exchange, routingKey, new MessageWrapper<>(reportMessage));
        LOGGER.info("投递消息 {} to exchange {} with {} ", reportMessage, exchange, routingKey);
    }
}
