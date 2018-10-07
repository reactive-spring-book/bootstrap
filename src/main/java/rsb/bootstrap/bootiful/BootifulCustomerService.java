package rsb.bootstrap.bootiful;

import org.springframework.stereotype.Service;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

@Service
public class BootifulCustomerService extends BaseCustomerService
		implements CustomerService {

	private final DataSource dataSource;

	public BootifulCustomerService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

}
