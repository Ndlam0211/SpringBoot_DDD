package com.lamnd.controller.resource;

import com.lamnd.application.service.event.EventAppService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @RateLimiter(name = "backendA", fallbackMethod = "helloFallback")
    public String hello() {
        return eventAppService.sayHi("Lam");
    }

    public String helloFallback() {
        return "Too many requests. Please try again later.";
    }

    @GetMapping("/hi2")
    @RateLimiter(name = "backendB", fallbackMethod = "helloFallback")
    public String hello2() {
        return eventAppService.sayHi("Lam2");
    }

    @GetMapping("/circuit/breaker")
    @CircuitBreaker(name = "default", fallbackMethod = "circuitBreakerFallback")
    public String circuitBreaker() {
        return eventAppService.sayHi("Lam3");
    }

    public String circuitBreakerFallback() {
        return "Service error. Please try again later.";
    }
}
