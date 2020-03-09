package br.com.orion.helloservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class HelloServiceApplication {

	@GetMapping("/hello")
    public String greet() {
        return "Hello Service A";
    }


	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

}
