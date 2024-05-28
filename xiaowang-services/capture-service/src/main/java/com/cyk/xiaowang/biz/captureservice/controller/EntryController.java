package com.cyk.xiaowang.biz.captureservice.controller;

import com.cyk.xiaowang.biz.captureservice.req.AgentCameraReq;
import com.cyk.xiaowang.biz.captureservice.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class EntryController.
 **/
@RestController
@RequiredArgsConstructor
public class EntryController {

    private final EntryService entryService;

    @PostMapping("/api/capture-service/agent/camera")
    public String agentCamera(@RequestBody AgentCameraReq agentCameraReq) {
        entryService.agentCamera(agentCameraReq);
        return "success";
    }
}
