package rsb.bootstrap.templates;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.DataSourceUtils;
import rsb.bootstrap.Demo;

import javax.sql.DataSource;

public class Application {

	public static void main(String args[]) {

		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).build();

		DataSource initializedDataSource = DataSourceUtils.initializeDdl(dataSource);

		TransactionTemplateCustomerService customerService = new TransactionTemplateCustomerService(
				initializedDataSource);

		Demo.workWithCustomerService(Application.class, customerService);
	}

}
