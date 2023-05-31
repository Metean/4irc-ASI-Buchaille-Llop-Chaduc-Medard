package com.cpe.vengaboys.asi.controllers;

import com.cpe.vengaboys.asi.annotations.ApiRestController;
import org.springframework.web.bind.annotation.GetMapping;

@ApiRestController() // /api/test
public class TestController {

    @GetMapping("/test/test") // /api/test/test
    public String test() {
        return "test ok";
    }
}

