package rsb.bootstrap.bootiful;

import org.springframework.stereotype.Service;
import rsb.bootstrap.enable.TransactionalCustomerService;

import javax.sql.DataSource;

// <1>
@Service
class BootifulCustomerService extends TransactionalCustomerService {

	BootifulCustomerService(DataSource dataSource) {
		super(dataSource);
	}

}
