package com.cyk.xiaowang.biz.hb2service.enums;

import lombok.Getter;

/**
 * The enum BindingKey.
 **/
@Getter
public enum BindingKey {

    BUSINESS_BINDING_KEY("com.cyk.xiaowang.business.*");

    private final String name;

    BindingKey(String name) {
        this.name = name;
    }
}
