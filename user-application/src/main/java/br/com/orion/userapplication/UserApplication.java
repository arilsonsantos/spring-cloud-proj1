package br.com.orion.userapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableEurekaClient
@RestController
@SpringBootApplication
@EnableFeignClients
public class UserApplication {

	@Autowired
	IHelloService client;

	@GetMapping("/")
	public String hello() {
		return client.Hello();
	}

	@FeignClient("hello-service")
	interface IHelloService {
		@GetMapping(value="/hello")
		String Hello();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
