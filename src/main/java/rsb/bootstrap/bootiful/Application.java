package rsb.bootstrap.bootiful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.Demo;

// <1>
@SpringBootApplication
public class Application {

	public static void main(String args[]) {
		// <2>
		System.setProperty("spring.profiles.active", "prod");
		// <3>
		SpringApplication.run(Application.class, args);
	}
}

// <4>
@Profile("dev")
@Component
class DemoListener {

	private final CustomerService customerService;

	DemoListener(CustomerService customerService) {
		this.customerService = customerService;
	}

	// <5>
	@EventListener(ApplicationReadyEvent.class)
	public void exercise() {
		Demo.workWithCustomerService(getClass(), this.customerService);
	}
}