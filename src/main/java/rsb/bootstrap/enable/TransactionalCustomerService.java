package rsb.bootstrap.enable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.Customer;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;
import java.util.Collection;

@Service
public class TransactionalCustomerService extends BaseCustomerService
		implements CustomerService {

	private final DataSource dataSource;

	public TransactionalCustomerService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
	}

	@Transactional
	@Override
	public Customer save(String name) {
		return super.save(name);
	}

	@Override
	@Transactional
	public Customer findById(Long id) {
		return super.findById(id);
	}

	@Transactional
	@Override
	public Collection<Customer> findAll() {
		return super.findAll();
	}

}
