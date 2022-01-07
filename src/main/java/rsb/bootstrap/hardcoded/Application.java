package rsb.bootstrap.hardcoded;

import rsb.bootstrap.Demo;

public class Application {

	public static void main(String[] args) {
		var customerService = new DevelopmentOnlyCustomerService();
		Demo.workWithCustomerService(Application.class, customerService);
	}

}
