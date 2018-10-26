package rsb.bootstrap;

import org.junit.Assert;

public interface TransactionTestMixin {

	default void testTransactionalityOfSave(CustomerService customerService) {
		int count = customerService.findAll().size();
		try {
			customerService.save("Bob", null);
		}
		catch (Exception ex) {
			Assert.assertEquals("there should be no new records in the database",
					customerService.findAll().size(), count);
			return;
		}
		Assert.fail();
	}

}
