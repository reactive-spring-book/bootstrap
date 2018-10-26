package rsb.bootstrap;

import java.util.Collection;

public interface CustomerService {

	Collection<Customer> save(String... names);

	Customer findById(Long id);

	Collection<Customer> findAll();

}
