package com.zmx.springbeansinit.service;

import com.zmx.springbeansinit.model.Animal;

public abstract class CookService {
    /**
     *
     */
    private static final String BBQ = "BBQ";

    public String value() {
        return BBQ;
    }

    protected abstract Animal getBreathing();

    private void postConstruct() {
        System.out.println("Hello from @PostConstruct method");
    }

    public void preDestroy() {
        System.out.println("Bean is being destroyed");
    }
}
