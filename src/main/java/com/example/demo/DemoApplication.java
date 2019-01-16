package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Logger getLogger() {
		return LoggerFactory.getLogger("DemoStrategy");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		context.getBean(Context.class).doSth("FirstStrategy", "Pierwsza strategia");
		context.getBean(Context.class).doSth("SecondStrategy", "MOJA WIADOMOSC");
	}


}

