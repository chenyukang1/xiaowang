package com.cyk.xiaowang.biz.hb2service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The class HB2Application.
 **/
@SpringBootApplication
@EnableScheduling
public class HB2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HB2ServiceApplication.class, args);
    }
}
