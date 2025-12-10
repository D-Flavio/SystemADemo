package com.example.systemADemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SystemADemoApplication {

	public static void main(String[] args) {
        SpringApplication.run(SystemADemoApplication.class, args);
    }
}
