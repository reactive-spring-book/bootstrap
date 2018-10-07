package rsb.bootstrap.hardcoded;

import rsb.bootstrap.DataSourceUtils;

public class BootstrapApplication {

	public static void main(String[] args) {
		DevelopmentOnlyCustomerService dataSourceCustomerService = new DevelopmentOnlyCustomerService();
		DataSourceUtils.initializeDdl(dataSourceCustomerService.getDataSource());

	}

}
