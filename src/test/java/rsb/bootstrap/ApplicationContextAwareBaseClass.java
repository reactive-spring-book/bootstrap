package rsb.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

public abstract class ApplicationContextAwareBaseClass extends BaseClass {

	private final AtomicReference<ApplicationContext> reference = new AtomicReference<>();

	@Override
	public CustomerService getCustomerService() {
		if (this.reference.get() == null) {
			ApplicationContext applicationContext = this
					.buildApplicationContext(getConfigurationClass(), "prod");
			this.reference.set(applicationContext);
		}
		return this.reference.get().getBean(CustomerService.class);
	}

	protected ApplicationContext buildApplicationContext(Class<?> config,
			String... profiles) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(profiles);
		context.register(config);
		context.refresh();
		context.start();
		return context;
	}

	protected abstract Class<?> getConfigurationClass();

}
