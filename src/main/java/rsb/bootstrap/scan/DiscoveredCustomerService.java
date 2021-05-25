package rsb.bootstrap.scan;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.templates.TransactionTemplateCustomerService;

import javax.sql.DataSource;

// <1>
@Service
class DiscoveredCustomerService extends TransactionTemplateCustomerService {

	// <2>
	DiscoveredCustomerService(DataSource dataSource, TransactionTemplate tt) {
		super(dataSource, tt);
	}

}
