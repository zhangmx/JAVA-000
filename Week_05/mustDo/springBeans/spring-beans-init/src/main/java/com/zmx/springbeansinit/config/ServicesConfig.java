package com.zmx.springbeansinit.config;

import com.zmx.springbeansinit.model.Animal;
import com.zmx.springbeansinit.service.CookService;
import com.zmx.springbeansinit.service.LeaveService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {
    
    @Bean
    LeaveService cook(){
        return new LeaveService();
    }
}
