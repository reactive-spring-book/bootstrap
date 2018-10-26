package rsb.bootstrap.templates;

import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.BaseCustomerService;
import rsb.bootstrap.Customer;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Collections;

public class TransactionTemplateCustomerService extends BaseCustomerService {

	private final TransactionTemplate transactionTemplate;

	public TransactionTemplateCustomerService(DataSource dataSource,
			TransactionTemplate tt) {
		super(dataSource);
		this.transactionTemplate = tt;
	}

	private <T> T rollbackIfNecessary(TransactionCallback<T> target,
			T resultIfRolledBack) {
		TransactionCallback<T> callback = status -> {
			try {
				return target.doInTransaction(status);
			}
			catch (IllegalArgumentException e) {
				status.setRollbackOnly();
				return resultIfRolledBack;
			}
		};
		return this.transactionTemplate.execute(target);
	}

	@Override
	public Collection<Customer> save(String... names) {
		return this.rollbackIfNecessary(s -> super.save(names), Collections.emptyList());
	}

	@Override
	public Customer findById(Long id) {
		return this.rollbackIfNecessary(s -> super.findById(id), null);
	}

	@Override
	public Collection<Customer> findAll() {
		return this.rollbackIfNecessary(s -> super.findAll(), Collections.emptyList());
	}

}
