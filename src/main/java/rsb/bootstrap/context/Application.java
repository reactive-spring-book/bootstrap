package rsb.bootstrap.context;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rsb.bootstrap.*;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class Application {

	@Bean
	TransactionTemplateCustomerService customerService(DataSource dataSource) {
		return new TransactionTemplateCustomerService(
				DataSourceUtils.initializeDdl(dataSource));
	}

	public static void main(String args[]) {
		ConfigurableApplicationContext applicationContext = SpringUtils
				.run(Application.class, "prod");

		CustomerService cs = applicationContext.getBean(CustomerService.class);
		Demo.workWithCustomerService(Application.class, cs);
	}

}
