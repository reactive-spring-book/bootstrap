package rsb.bootstrap.bootiful;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.Demo;

@SpringBootApplication
public class Application {

	public static void main(String args[]) {
		System.setProperty("spring.profiles.active", "prod");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Profile("default")
	ApplicationRunner run(CustomerService customerService) {
		return args -> Demo.workWithCustomerService(getClass(), customerService);
	}

}
