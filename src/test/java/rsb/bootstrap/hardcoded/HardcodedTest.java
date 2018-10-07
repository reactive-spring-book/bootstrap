package rsb.bootstrap.hardcoded;

import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;
import rsb.bootstrap.DataSourceUtils;

public class HardcodedTest extends BaseClass {

	private final CustomerService customerService;

	public HardcodedTest() {
		DevelopmentOnlyCustomerService customerService = new DevelopmentOnlyCustomerService();
		DataSourceUtils.initializeDdl(customerService.getDataSource());
		this.customerService = customerService;
	}

	@Override
	public CustomerService getCustomerService() {
		return this.customerService;
	}

}
