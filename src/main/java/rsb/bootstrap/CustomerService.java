package rsb.bootstrap;

import java.util.Collection;

public interface CustomerService {

	Customer save(String name);

	Customer findById(Long id);

	Collection<Customer> findAll();

}
