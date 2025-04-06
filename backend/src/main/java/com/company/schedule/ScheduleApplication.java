package com.company.schedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.company.schedule.ScheduleApplication.class, args);
	}
	@Bean
    public CommandLineRunner runOnStartup() {
        return args -> {
            System.out.println("✅ EL BACKEND ARRANCÓ CORRECTAMENTE 🚀");
        };
    }

}
