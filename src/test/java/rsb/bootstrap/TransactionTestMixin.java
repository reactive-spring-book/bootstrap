package rsb.bootstrap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;

public interface TransactionTestMixin {

	default void testTransactionalityOfSave(CustomerService customerService) {
		Log log = LogFactory.getLog(getClass());
		log.info("using customer " + customerService.toString());
		int count = customerService.findAll().size();
		try {
			customerService.save("Bob", null);
		}
		catch (Exception ex) {
			Assertions.assertEquals(count, customerService.findAll().size(),
					"there should be no new records in the database");
			return;
		}
		Assertions.fail();
	}

}
