package rsb.bootstrap.basicdi;

import rsb.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

class DataSourceCustomerService extends BaseCustomerService {

	// <1>
	DataSourceCustomerService(DataSource ds) {
		super(ds);
	}

}
