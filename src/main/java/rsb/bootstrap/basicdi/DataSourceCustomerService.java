package rsb.bootstrap.basicdi;

import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

class DataSourceCustomerService extends BaseCustomerService {

	// <1>
	DataSourceCustomerService(DataSource ds) {
		super(ds);
	}

}
