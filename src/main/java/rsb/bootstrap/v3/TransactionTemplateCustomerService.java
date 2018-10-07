package rsb.bootstrap.v3;

import lombok.ToString;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.Customer;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;
import java.util.Collection;

@ToString
public class TransactionTemplateCustomerService extends BaseCustomerService
		implements CustomerService {

	private final DataSource dataSource;

	private final TransactionTemplate transactionTemplate;

	public TransactionTemplateCustomerService(DataSource ds) {
		this.dataSource = ds;

		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(
				this.dataSource);

		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}

	@Override
	protected DataSource getDataSource() {
		return this.dataSource;
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
