package com.cyk.xiaowang.biz.hb2service.enums;

import lombok.Getter;

/**
 * The enum EXCHANGE.
 **/
@Getter
public enum Exchange {

    BUSINESS("com.cyk.xiaowang.business.exchange"),
    DEAD_LETTER("com.cyk.xiaowang.deadLetter.exchange");

    private final String name;

    Exchange(String name) {
        this.name = name;
    }
}
