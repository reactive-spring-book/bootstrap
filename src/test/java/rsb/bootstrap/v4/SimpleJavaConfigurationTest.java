package rsb.bootstrap.v4;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import rsb.bootstrap.BaseClass;
import rsb.bootstrap.CustomerService;

import java.util.concurrent.atomic.AtomicReference;

@Log4j2
public class SimpleJavaConfigurationTest extends BaseClass {

	private final AtomicReference<ApplicationContext> applicationContextAtomicReference = new AtomicReference<>();

	private ApplicationContext buildApplicationContext(Class<?> config,
			String... profiles) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(profiles);
		context.register(config);
		context.refresh();
		context.start();
		return context;
	}

	@Override
	public CustomerService getCustomerService() {
		if (this.applicationContextAtomicReference.get() == null) {
			ApplicationContext applicationContext = this
					.buildApplicationContext(BootstrapApplication.class, "prod");
			this.applicationContextAtomicReference.set(applicationContext);
		}
		return this.applicationContextAtomicReference.get()
				.getBean(CustomerService.class);
	}

}
