package rsb.bootstrap.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceUtils;
import rsb.bootstrap.DataSourceConfiguration;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class BootstrapApplication {

	@Bean
	TransactionTemplateCustomerService customerService(DataSource dataSource) {
		return new TransactionTemplateCustomerService(
				DataSourceUtils.initializeDdl(dataSource));
	}

	public static void main(String args[]) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.register(BootstrapApplication.class);
		applicationContext.refresh();
		applicationContext.start();
		CustomerService cs = applicationContext.getBean(CustomerService.class);
	}

}
