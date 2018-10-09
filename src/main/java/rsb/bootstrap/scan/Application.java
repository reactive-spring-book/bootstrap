package rsb.bootstrap.scan;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceConfiguration;
import rsb.bootstrap.Demo;
import rsb.bootstrap.SpringUtils;

@Configuration
@ComponentScan
@Import(DataSourceConfiguration.class)
public class Application {

	public static void main(String args[]) {
		ConfigurableApplicationContext applicationContext = SpringUtils
				.run(Application.class, "prod");
		CustomerService customerService = applicationContext
				.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, customerService);
	}

}
