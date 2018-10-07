package rsb.bootstrap;

import lombok.extern.log4j.Log4j2;
import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

@Log4j2
@Configuration
public class SimpleJavaConfiguration {

	@Configuration
	@PropertySource("application-prod.properties")
	@Profile("prod")
	public static class ProductionConfiguration {

		@Bean
		DataSource productionDataSource(@Value("${spring.datasource.url}") String url,
				@Value("${spring.datasource.username}") String username,
				@Value("${spring.datasource.password}") String password) {
			DriverManagerDataSource dataSource = new DriverManagerDataSource(url,
					username, password);
			dataSource.setDriverClassName(Driver.class.getName());
			return dataSource;
		}

	}

	@Configuration
	@Profile("default")
	@PropertySource("application-default.properties")
	public static class DevelopmentConfiguration {

		@Bean
		DataSource developmentDataSource() {
			return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		}

	}

}
