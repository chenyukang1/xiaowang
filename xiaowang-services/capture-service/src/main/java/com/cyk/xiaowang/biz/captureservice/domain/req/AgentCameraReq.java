package com.cyk.xiaowang.biz.captureservice.domain.req;

import lombok.Data;

/**
 * The class AgentCameraReq.
 **/
@Data
public class AgentCameraReq {
    private String camId;

    private String command;

    private String vendor;
}
