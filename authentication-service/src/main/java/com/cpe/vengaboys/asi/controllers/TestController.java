package com.cpe.vengaboys.asi.controllers;

import com.cpe.vengaboys.asi.annotations.ApiRestController;
import org.springframework.web.bind.annotation.GetMapping;

@ApiRestController()
public class TestController {

    @GetMapping("/ping")
    public String test() {
        return "pong";
    }
}

