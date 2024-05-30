package com.cyk.xiaowang.biz.hb2service.domain;

import lombok.Builder;
import lombok.Data;

/**
 * The class Message.
 **/
@Data
@Builder
public class ReportMessage {

    private String message;

    private String reporter;

    private String picUrl;

    private Long picId;
}
