package com.shypz.shypzuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan
@ComponentScan
public class ShypzUserApiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(ShypzUserApiApp.class,args );

	}

}
