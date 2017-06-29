package it.uniroma3.asw.r2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class R2Application {

	public static void main(String[] args) {
		SpringApplication.run(R2Application.class, args);
	}
}
