package com.j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
public class ServiceHiApplication {

	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());


	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}



}
