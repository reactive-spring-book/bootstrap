package rsb.bootstrap;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

public abstract class SpringUtils {

	public static ConfigurableApplicationContext run(Class<?> sources, String profile) {
		// <1>
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		// <2>
		if (StringUtils.hasText(profile)) {
			applicationContext.getEnvironment().setActiveProfiles(profile);
		}

		// <3>
		applicationContext.register(sources);
		applicationContext.refresh();

		// <4>
		applicationContext.start();
		return applicationContext;
	}

}
