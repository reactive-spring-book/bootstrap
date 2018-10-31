package rsb.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

public interface TransactionTestMixin {

	default void testTransactionalityOfSave(CustomerService customerService) {
		Log log = LogFactory.getLog(getClass());
		log.info("using customer " + customerService.toString());
		int count = customerService.findAll().size();
		try {
			customerService.save("Bob", null);
		}
		catch (Exception ex) {
			Assert.assertEquals("there should be no new records in the database", count,
					customerService.findAll().size());
			return;
		}
		Assert.fail();
	}

}
