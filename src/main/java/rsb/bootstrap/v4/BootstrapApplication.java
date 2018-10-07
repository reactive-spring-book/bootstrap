package rsb.bootstrap.v4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SimpleJavaConfiguration.class)
public class BootstrapApplication {

	public static void main(String args[]) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.register(BootstrapApplication.class);
		applicationContext.refresh();

	}

}
