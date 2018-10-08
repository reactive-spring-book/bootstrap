package rsb.bootstrap.basicdi;

import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

public class DataSourceCustomerService extends BaseCustomerService
		implements CustomerService {

	private final DataSource dataSource;

	public DataSourceCustomerService(DataSource ds) {
		this.dataSource = ds;
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

}
