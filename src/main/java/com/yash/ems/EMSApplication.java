package com.yash.ems;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(EMSApplication.class, args);
		System.out.println("EMS Application started now...!!!");
		
	}
	
	 
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

}
