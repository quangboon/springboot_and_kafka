package com.kafka.demokafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class DemoKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoKafkaApplication.class, args);
	}

	@Bean
	NewTopic notification(){
		return new NewTopic("notification", 2, (short)1);
	}

	@Bean
	NewTopic statistic(){
		// topic name , partition numbers, replication number
		return new NewTopic("statistic", 1, (short)1);
	}
}
