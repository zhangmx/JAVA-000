package com.zmx.springbeansinit.config;

import com.zmx.springbeansinit.model.Animal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {
    
    @Bean
    Animal animal(){
        return new Animal("pig");
    }
}
