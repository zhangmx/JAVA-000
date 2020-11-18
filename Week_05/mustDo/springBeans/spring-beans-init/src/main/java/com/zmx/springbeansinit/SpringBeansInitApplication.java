package com.zmx.springbeansinit;

import java.util.Arrays;

import com.zmx.springbeansinit.service.CookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.CommandLinePropertySource;

@SpringBootApplication
public class SpringBeansInitApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext applicationContext;
	// CookService calculateService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBeansInitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));

	}
}
