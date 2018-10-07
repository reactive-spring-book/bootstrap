package rsb.bootstrap;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public abstract class BaseClass {

	public abstract CustomerService getCustomerService();

	@Test
	public void insert() throws Exception {
		Customer bob = getCustomerService().save("BOB");
		Assert.assertNotNull(bob);
	}

	@Test
	public void getAllCustomers() {
		Stream.of("A", "B").forEach(getCustomerService()::save);
		Assert.assertTrue(getCustomerService().findAll().size() > 2);
	}

	@Test
	public void byId() {
		Long id = getCustomerService().save("A").getId();
		Assert.assertEquals(id, getCustomerService().findById(id).getId());
	}

}
