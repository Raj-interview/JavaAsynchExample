package com.rah.asynch.controller;

import com.rah.asynch.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class SampleController {

    @Inject private SampleService feignClientService;

    @RequestMapping(value = "/healthCheck", method = RequestMethod.GET, produces = "application/json")
    public boolean isAlive() {
        return feignClientService.healthCheck();
    }
}
