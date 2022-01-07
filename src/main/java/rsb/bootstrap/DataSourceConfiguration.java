package rsb.bootstrap;

import org.h2.Driver;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

	// <1>
	@Configuration
	@Profile("prod") // <2>
	@PropertySource("application-prod.properties") // <3>
	public static class ProductionConfiguration {

		@Bean
		DataSource productionDataSource(@Value("${spring.datasource.url}") String url, // <4>
				@Value("${spring.datasource.username}") String username,
				@Value("${spring.datasource.password}") String password,
				@Value("${spring.datasource.driver-class-name}") Class<Driver> driverClass // <5>
		) {
			var dataSource = new DriverManagerDataSource(url, username, password);
			dataSource.setDriverClassName(driverClass.getName());
			return dataSource;
		}

	}

	@Configuration
	@Profile("default") // <6>
	@PropertySource("application-default.properties")
	public static class DevelopmentConfiguration {

		@Bean
		DataSource developmentDataSource() {
			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		}

	}

	@Bean
	DataSourcePostProcessor dataSourcePostProcessor() {
		return new DataSourcePostProcessor();
	}

	// <7>
	private static class DataSourcePostProcessor implements BeanPostProcessor {

		@Override
		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			if (bean instanceof DataSource ds) {
				DataSourceUtils.initializeDdl(ds);
			}
			return bean;
		}

	}

}
