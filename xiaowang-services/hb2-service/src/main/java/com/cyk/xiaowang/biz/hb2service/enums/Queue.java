package com.cyk.xiaowang.biz.hb2service.enums;

import lombok.Getter;

/**
 * The enum Queue.
 **/
@Getter
public enum Queue {

    BUSINESS("com.cyk.xiaowang.business.queue"),
    DEAD_LETTER("com.cyk.xiaowang.deadLetter.queue");

    private final String name;

    Queue(String name) {
        this.name = name;
    }
}
