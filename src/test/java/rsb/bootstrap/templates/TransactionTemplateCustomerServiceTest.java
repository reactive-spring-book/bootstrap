package rsb.bootstrap.templates;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.Customer;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;

public class TransactionTemplateCustomerServiceTest extends BaseClass {

	private final TransactionTemplateCustomerService customerService;

	public TransactionTemplateCustomerServiceTest() {
		DataSource ds = DataSourceUtils.initializeDdl(
				new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build());
		PlatformTransactionManager txm = new DataSourceTransactionManager(ds);
		TransactionTemplate tt = new TransactionTemplate(txm);
		this.customerService = new TransactionTemplateCustomerService(ds, tt);
	}

	@Override
	@Test
	public void insert() {
		super.insert();
		int count = getCustomerService().findAll().size();
		Collection<Customer> customers = new ArrayList<>();
		try {
			customers = getCustomerService().save("Bob", null);
		}
		catch (Exception e) {
			Assert.assertEquals(customers.size(), 0);
			Assert.assertEquals(getCustomerService().findAll().size(), count);
			return;
		}
		Assert.fail();

	}

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}