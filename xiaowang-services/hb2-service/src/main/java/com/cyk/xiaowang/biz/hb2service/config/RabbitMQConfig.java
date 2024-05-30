package com.cyk.xiaowang.biz.hb2service.config;

import com.cyk.xiaowang.biz.hb2service.enums.BindingKey;
import com.cyk.xiaowang.biz.hb2service.enums.Exchange;
import com.cyk.xiaowang.biz.hb2service.enums.RoutingKey;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * The class RabbitMQConfig.
 **/
@Configuration
public class RabbitMQConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 消息序列化
     *
     * @param connectionFactory    the connection factory
     * @param jsonMessageConverter the json message converter
     * @return the rabbit template
     */
//    @Bean
//    public RabbitTemplate jacksonRabbitTemplate(ConnectionFactory connectionFactory, MessageConverter jsonMessageConverter) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter);
//        return rabbitTemplate;
//    }
//
//    /**
//     * 消息反序列化
//     *
//     * @param connectionFactory    the connection factory
//     * @param jsonMessageConverter the json message converter
//     * @return the rabbit listener container factory
//     */
//    @Bean
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
//                                                                            MessageConverter jsonMessageConverter) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(jsonMessageConverter);
//        return factory;
//    }

    @Bean("businessExchange")
    public TopicExchange businessExchange() {
        return new TopicExchange(Exchange.BUSINESS.getName());
    }

    @Bean("businessQueue")
    public Queue businessQueue() {
        Map<String, Object> args = new HashMap<>();
        // 声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", Exchange.DEAD_LETTER.getName());
        // 声明当前队列的死信路由键
        args.put("x-dead-letter-routing-key", RoutingKey.DEAD_LETTER_ROUTING_KEY.getName());
        return QueueBuilder.durable(com.cyk.xiaowang.biz.hb2service.enums.Queue.BUSINESS.getName())
                .withArguments(args)
                .build();
    }

    @Bean
    public Binding businessBinding(@Qualifier("businessQueue")Queue businessQueue,
                                   @Qualifier("businessExchange") TopicExchange businessExchange) {
        return BindingBuilder.bind(businessQueue)
                .to(businessExchange)
                .with(BindingKey.BUSINESS_BINDING_KEY.getName());
    }

    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(Exchange.DEAD_LETTER.getName());
    }

    @Bean("deadLetterQueue")
    public Queue deadLetterQueue() {
        return new Queue(com.cyk.xiaowang.biz.hb2service.enums.Queue.DEAD_LETTER.getName());
    }

    @Bean
    public Binding deadLetterBinding(@Qualifier("deadLetterQueue")Queue deadLetterQueue,
                                     @Qualifier("deadLetterExchange") DirectExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue)
                .to(deadLetterExchange)
                .with(RoutingKey.DEAD_LETTER_ROUTING_KEY.getName());
    }
}
