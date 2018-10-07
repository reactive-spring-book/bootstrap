package rsb.bootstrap.v1;

import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;

public class DevelopmentOnlyCustomerServiceTest extends BaseClass {

	private final CustomerService customerService;

	public DevelopmentOnlyCustomerServiceTest() {
		this.customerService = new DevelopmentOnlyCustomerService();
	}

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}
