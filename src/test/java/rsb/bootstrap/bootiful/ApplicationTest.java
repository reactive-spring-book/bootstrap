package rsb.bootstrap.bootiful;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import rsb.bootstrap.ApplicationContextAwareBaseClass;

import java.util.concurrent.atomic.AtomicReference;

@Log4j2
public class ApplicationTest extends ApplicationContextAwareBaseClass {

	private final AtomicReference<ApplicationContext> contextAtomicReference = new AtomicReference<>();

	@Override
	protected ConfigurableApplicationContext buildApplicationContext(Class<?> config, String... profiles) {
		return new SpringApplicationBuilder().profiles(profiles).sources(config).run();
	}

	@Override
	protected Class<?> getConfigurationClass() {
		return Application.class;
	}

}