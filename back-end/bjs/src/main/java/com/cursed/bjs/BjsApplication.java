package com.cursed.bjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cursed.bjs", "com.cursed.bjs.database", "com.cursed.bjs.controllers", "com.cursed.bjs.services"})
public class BjsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjsApplication.class, args);
	}

}
