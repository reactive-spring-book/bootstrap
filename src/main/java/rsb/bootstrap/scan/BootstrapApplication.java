package rsb.bootstrap.scan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rsb.bootstrap.DataSourceConfiguration;

// 5.0
@Configuration
@ComponentScan
@Import(DataSourceConfiguration.class)
public class BootstrapApplication {

	public static void main(String args[]) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.register(BootstrapApplication.class);
		applicationContext.refresh();

	}

}
