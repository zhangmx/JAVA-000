package com.zmx.springbeansinit.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class BurnService {
    @PostConstruct
    private void postConstruct() {
        System.out.println("Hello from @PostConstruct method");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Bean is being destroyed");
    }
}
