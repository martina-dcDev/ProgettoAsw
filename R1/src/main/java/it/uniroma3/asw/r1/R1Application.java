package it.uniroma3.asw.r1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class R1Application {

	public static void main(String[] args) {
		SpringApplication.run(R1Application.class, args);
	}
}
