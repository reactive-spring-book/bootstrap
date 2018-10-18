package rsb.bootstrap.bootiful;

import org.springframework.stereotype.Service;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

@Service
class BootifulCustomerService extends BaseCustomerService {

	BootifulCustomerService(DataSource ds) {
		super(ds);
	}

}
