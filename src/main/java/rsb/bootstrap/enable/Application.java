package rsb.bootstrap.enable;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceConfiguration;
import rsb.bootstrap.Demo;
import rsb.bootstrap.SpringUtils;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan
@Import(DataSourceConfiguration.class)
public class Application {

	@Bean
	PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

	@Bean
	TransactionTemplate transactionTemplate(PlatformTransactionManager tm) {
		return new TransactionTemplate(tm);
	}

	public static void main(String args[]) {
		ConfigurableApplicationContext applicationContext = SpringUtils
				.run(Application.class, "prod");
		CustomerService customerService = applicationContext
				.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, customerService);
	}

}
