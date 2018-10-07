package rsb.bootstrap.bootiful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootifulApplication {

	public static void main(String args[]) {
		System.setProperty("spring.profiles.active", "prod");
		SpringApplication.run(BootifulApplication.class, args);
	}

}
