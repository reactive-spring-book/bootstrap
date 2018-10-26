package rsb.bootstrap.context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.*;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class Application {

	@Bean
	PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	TransactionTemplateCustomerService customerService(DataSource ds,
			TransactionTemplate tt) {
		return new TransactionTemplateCustomerService(DataSourceUtils.initializeDdl(ds),
				tt);
	}

	@Bean
	TransactionTemplate transactionTemplate(
			PlatformTransactionManager transactionManager) {
		return new TransactionTemplate(transactionManager);
	}

	public static void main(String args[]) {
		ConfigurableApplicationContext applicationContext = SpringUtils
				.run(Application.class, "prod");

		CustomerService cs = applicationContext.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, cs);
	}

}
