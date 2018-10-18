package rsb.bootstrap.templates;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.Customer;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;
import java.util.Collection;

public class TransactionTemplateCustomerService extends BaseCustomerService {

	private final TransactionTemplate transactionTemplate;

	public TransactionTemplateCustomerService(DataSource ds) {
		super(ds);
		PlatformTransactionManager txManager = new DataSourceTransactionManager(ds);
		this.transactionTemplate = new TransactionTemplate(txManager);
	}

	@Override
	public Customer save(String name) {
		return transactionTemplate.execute(status -> super.save(name));
	}

	@Override
	public Customer findById(Long id) {
		return transactionTemplate.execute(status -> super.findById(id));
	}

	@Override
	public Collection<Customer> findAll() {
		return transactionTemplate.execute(status -> super.findAll());
	}

}
