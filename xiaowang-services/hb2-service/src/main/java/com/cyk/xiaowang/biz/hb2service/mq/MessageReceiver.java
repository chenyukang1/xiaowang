package com.cyk.xiaowang.biz.hb2service.mq;

import com.cyk.xiaowang.biz.hb2service.domain.mq.MessageWrapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * The class MessageReceiver.
 **/
@Component
public class MessageReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);

    @RabbitListener(queues = "${hb2.mq.business.queue:com.cyk.xiaowang.business.queue}", ackMode = "MANUAL")
    public <T> void receive(MessageWrapper<T>  messageWrapper, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                         Channel channel) throws IOException {
        LOGGER.info("收到业务消息 '{}'", messageWrapper);

//        if (messageWrapper.getMessage().contains("success")) {
            // RabbitMQ的ack机制中，第二个参数返回true，表示确认当前及之前所有未确认的消息
//            channel.basicAck(deliveryTag, false);
//        } else {
            // 第三个参数true，表示这个消息会重新进入队列
            channel.basicNack(deliveryTag, false, false);
//        }
    }

    @RabbitListener(queues = "${hb2.mq.dead-letter.queue:com.cyk.xiaowang.deadLetter.queue}", ackMode = "MANUAL")
    public <T> void receiveDDL(MessageWrapper<T>  messageWrapper, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                            Channel channel) throws IOException {
        LOGGER.info("收到死信消息 '{}'", messageWrapper);
        channel.basicAck(deliveryTag, false);
    }
}
