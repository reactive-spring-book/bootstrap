package rsb.bootstrap.basicdi;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceUtils;

import javax.sql.DataSource;

public class BootstrapApplication {

	public static void main(String[] args) {

		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).build();

		DataSource initializedDataSource = DataSourceUtils.initializeDdl(dataSource);
		CustomerService cs = new DataSourceCustomerService(initializedDataSource);

	}

}
