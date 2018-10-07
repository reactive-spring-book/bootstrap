package rsb.bootstrap.templates;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.Customer;
import rsb.bootstrap.CustomerService;

import javax.sql.DataSource;

public class TransactionTemplateCustomerServiceTest extends BaseClass {

	private final TransactionTemplateCustomerService customerService;

	private DataSource init(DataSource dataSource) {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator(
				new ClassPathResource("schema.sql"));
		DatabasePopulatorUtils.execute(populator, dataSource);
		return dataSource;
	}

	public TransactionTemplateCustomerServiceTest() {
		DataSource dataSource = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).build();
		this.customerService = new TransactionTemplateCustomerService(init(dataSource));
	}

	@Override
	@Test
	public void insert() {
		int count = getCustomerService().findAll().size();
		try {
			Customer bob = getCustomerService().save("Bob");
			Assert.assertNotNull(bob);
			getCustomerService().save(null);
		}
		catch (Exception ex) {
			Assert.assertEquals("there should be one more record in the database",
					getCustomerService().findAll().size(), 1 + count);
			return;
		}
		Assert.fail();
	}

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}