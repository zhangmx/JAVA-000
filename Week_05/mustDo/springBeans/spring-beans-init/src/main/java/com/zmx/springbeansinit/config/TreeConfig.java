package com.zmx.springbeansinit.config;

import com.zmx.springbeansinit.model.Tree;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Tree.class)
public class TreeConfig {
    
}
