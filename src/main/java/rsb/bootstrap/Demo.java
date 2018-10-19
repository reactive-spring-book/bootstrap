package rsb.bootstrap;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.Assert;

import java.util.stream.Stream;

@Log4j2
public class Demo {

	public static void workWithCustomerService(Class<?> label,
			CustomerService customerService) {
		// <1>
		log.info("====================================");
		log.info(label.getName());
		log.info("====================================");

		// <2>
		Stream.of("A", "B", "C")
			.map(customerService::save)
				.forEach(customer -> log.info("saved " + customer.toString()));

		// <3>
		customerService.findAll().forEach(customer -> {
			Long customerId = customer.getId();
			// <4>
			Customer byId = customerService.findById(customerId);
			log.info("found " + byId.toString());
			Assert.notNull(byId, "the resulting customer should not be null");
			Assert.isTrue(byId.equals(customer),
					"we should be able to query for " + "this result");
		});
	}

}
