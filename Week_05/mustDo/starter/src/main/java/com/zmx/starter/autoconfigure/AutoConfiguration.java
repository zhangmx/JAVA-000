package com.zmx.starter.autoconfigure;

import com.zmx.starter.domain.ISchool;
import com.zmx.starter.domain.Klass;
import com.zmx.starter.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(School.class)
@EnableConfigurationProperties(Properties.class)
public class AutoConfiguration {

    @Autowired
    private Properties properties;

    @Bean
    @ConditionalOnMissingBean
    public Klass klass() {
        return new Klass();
    }

    @Bean
    @ConditionalOnMissingBean
    public ISchool school(Klass klass) {
        School school = new School();
        school.setClass1(klass);
        return school;
    }

}
