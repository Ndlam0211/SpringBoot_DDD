package com.lamnd.controller.resource;

import com.lamnd.application.service.event.EventAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;

    @GetMapping("/hi")
    public String hello() {
        return eventAppService.sayHi("Lam");
    }

    @GetMapping("/hi2")
    public String hello2() {
        return eventAppService.sayHi("Lam2");
    }
}
