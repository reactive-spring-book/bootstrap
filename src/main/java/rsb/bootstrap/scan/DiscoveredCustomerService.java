package rsb.bootstrap.scan;

import org.springframework.stereotype.Service;
import rsb.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

@Service
public class DiscoveredCustomerService extends BaseCustomerService {

	private final DataSource dataSource;

	public DiscoveredCustomerService(DataSource ds) {
		this.dataSource = ds;
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

}
