package rsb.bootstrap.basicdi;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import rsb.bootstrap.DataSourceUtils;
import rsb.bootstrap.Demo;

public class Application {

	public static void main(String[] args) {
		// <1>
		var dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
		// <2>
		var initializedDataSource = DataSourceUtils.initializeDdl(dataSource);
		var cs = new DataSourceCustomerService(initializedDataSource);
		Demo.workWithCustomerService(Application.class, cs);
	}

}
