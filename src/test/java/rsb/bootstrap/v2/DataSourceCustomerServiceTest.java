package rsb.bootstrap.v2;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

public class DataSourceCustomerServiceTest extends BaseClass {

	private final DataSourceCustomerService customerService;

	public DataSourceCustomerServiceTest() {
		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).addScript("/schema.sql").build();
		this.customerService = new DataSourceCustomerService(dataSource);
	}

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}