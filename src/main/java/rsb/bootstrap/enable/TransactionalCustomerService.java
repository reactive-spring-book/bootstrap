package rsb.bootstrap.enable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rsb.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

@Service
@Transactional
public class TransactionalCustomerService extends BaseCustomerService {

	private final DataSource dataSource;

	public TransactionalCustomerService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

}
