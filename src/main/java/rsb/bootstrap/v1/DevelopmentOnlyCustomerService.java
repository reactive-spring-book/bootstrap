package rsb.bootstrap.v1;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

public class DevelopmentOnlyCustomerService extends BaseCustomerService
		implements CustomerService {

	private final EmbeddedDatabase dataSource;

	public DevelopmentOnlyCustomerService() {
		this.dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("/schema.sql").build();
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

}
