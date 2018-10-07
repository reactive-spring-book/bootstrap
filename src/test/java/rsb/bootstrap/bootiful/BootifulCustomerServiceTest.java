package rsb.bootstrap.bootiful;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootifulCustomerServiceTest extends BaseClass {

	@Autowired
	private CustomerService customerService;

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}
