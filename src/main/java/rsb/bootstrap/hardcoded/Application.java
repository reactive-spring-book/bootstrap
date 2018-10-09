package rsb.bootstrap.hardcoded;

import rsb.bootstrap.DataSourceUtils;
import rsb.bootstrap.Demo;

public class Application {

	public static void main(String[] args) {
		DevelopmentOnlyCustomerService customerService = new DevelopmentOnlyCustomerService();
		DataSourceUtils.initializeDdl(customerService.getDataSource());
		Demo.workWithCustomerService(Application.class, customerService);
	}

}
