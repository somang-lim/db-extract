package com.vtw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VtwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtwApplication.class, args);
	}

}
