package rsb.bootstrap.enable;

import org.junit.Assert;
import org.junit.Test;
import rsb.bootstrap.ApplicationContextAwareBaseClass;
import rsb.bootstrap.Customer;

/**
 * @author <a href="mailto:josh@joshlong.com">Josh Long</a>
 */
public class EnableApplicationTest extends ApplicationContextAwareBaseClass {

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
	protected Class<?> getConfigurationClass() {
		return BootstrapApplication.class;
	}

}