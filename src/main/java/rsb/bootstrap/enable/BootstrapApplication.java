package rsb.bootstrap.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceConfiguration;

// 5.0
@Configuration
@EnableTransactionManagement
@ComponentScan
@Import(DataSourceConfiguration.class)
public class BootstrapApplication {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.register(rsb.bootstrap.context.BootstrapApplication.class);
		applicationContext.refresh();
		applicationContext.start();
		CustomerService cs = applicationContext.getBean(CustomerService.class);
	}

}
