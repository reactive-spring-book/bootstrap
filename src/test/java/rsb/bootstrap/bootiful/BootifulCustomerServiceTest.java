package rsb.bootstrap.bootiful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.TransactionTestMixin;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootifulCustomerServiceTest extends BaseClass
		implements TransactionTestMixin {

	@Autowired
	private CustomerService customerService;

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

	@Override
	@Test
	public void insert() {
		super.insert();
		this.testTransactionalityOfSave(getCustomerService());
	}

}
