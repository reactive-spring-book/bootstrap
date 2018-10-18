package rsb.bootstrap.scan;

import org.springframework.stereotype.Service;
import rsb.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

@Service
class DiscoveredCustomerService extends BaseCustomerService {

	public DiscoveredCustomerService(DataSource ds) {
		super(ds);
	}

}
