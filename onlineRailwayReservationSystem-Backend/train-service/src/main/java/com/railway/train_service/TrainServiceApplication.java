package com.railway.train_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "com.railway.train_service.model")
public class TrainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainServiceApplication.class, args);
	}


	/*@Bean
	CommandLineRunner testConnection(DataSource dataSource) {
		return args -> {
			try ( Connection connection = dataSource.getConnection()) {
				System.out.println("✅ CONNECTED TO DB: " + connection.getCatalog());
			}
		};
	}*/
}
