package com.cyk.xiaowang.biz.hb2service.domain.mq;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * The class MessageWrapper.
 **/
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public final class MessageWrapper<T> {

    /**
     * 消息体
     */
    @NonNull
    private T message;

    /**
     * 唯一标识，用于客户端幂等验证
     */
    private String uuid = UUID.randomUUID().toString();

    /**
     * 消息发送时间
     */
    private Long timestamp = System.currentTimeMillis();
}
