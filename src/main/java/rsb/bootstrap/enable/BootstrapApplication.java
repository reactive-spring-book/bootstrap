package rsb.bootstrap.enable;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceConfiguration;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan
@Import(DataSourceConfiguration.class)
public class BootstrapApplication {

	@Bean
	PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
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
