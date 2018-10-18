package rsb.bootstrap.hardcoded;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceUtils;

import javax.sql.DataSource;

class DevelopmentOnlyCustomerService extends BaseCustomerService {

	DevelopmentOnlyCustomerService() {
		super(buildDataSource());
	}

	private static DataSource buildDataSource() {
		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).build();
		return DataSourceUtils.initializeDdl(dataSource);
	}

}
