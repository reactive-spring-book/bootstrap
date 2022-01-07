package rsb.bootstrap;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

public abstract class DataSourceUtils {

	public static DataSource initializeDdl(DataSource dataSource) {
		// <1>
		var populator = new ResourceDatabasePopulator(new ClassPathResource("/schema.sql")); // <2>
		DatabasePopulatorUtils.execute(populator, dataSource);
		return dataSource;
	}

}
