package rsb.bootstrap.context;

import lombok.extern.log4j.Log4j2;
import rsb.bootstrap.ApplicationContextAwareBaseClass;

public class ContextTest extends ApplicationContextAwareBaseClass {

	@Override
	protected Class<?> getConfigurationClass() {
		return BootstrapApplication.class;
	}

}