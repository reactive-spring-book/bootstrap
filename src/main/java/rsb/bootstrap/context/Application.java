package rsb.bootstrap.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceConfiguration;
import rsb.bootstrap.Demo;
import rsb.bootstrap.SpringUtils;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

// <1>
@Configuration
@Import(DataSourceConfiguration.class) // <2>
public class Application {

	// <3>
	@Bean
	PlatformTransactionManager transactionManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}

	@Bean
	TransactionTemplateCustomerService customerService(DataSource ds,
			TransactionTemplate tt) {
		return new TransactionTemplateCustomerService(ds, tt);
	}

	@Bean
	TransactionTemplate transactionTemplate(PlatformTransactionManager tm) {
		return new TransactionTemplate(tm);
	}

	public static void main(String args[]) {
		// <4>
		ApplicationContext ac = SpringUtils.run(Application.class, "prod");

		// <5>
		CustomerService cs = ac.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, cs);
	}

}
