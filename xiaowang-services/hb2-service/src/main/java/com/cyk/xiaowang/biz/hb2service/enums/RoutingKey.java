package com.cyk.xiaowang.biz.hb2service.enums;

import lombok.Getter;

/**
 * The enum RoutingKey.
 **/
@Getter
public enum RoutingKey {

    DEAD_LETTER_ROUTING_KEY("com.cyk.xiaowang.deadLetter.routingKey");

    private final String name;

    RoutingKey(String name) {
        this.name = name;
    }
}
