package thymeleafexamples.sfs.business.entities.repositories;

import org.springframework.stereotype.Repository;

import thymeleafexamples.sfs.business.entities.Customer;

import java.util.Map;

@Repository
public class CustomerRepository {
	private static final CustomerRepository INSTANCE = new CustomerRepository();
	//private final Map<String, Customer> customerByName;

	public static CustomerRepository getInstance() {
        return INSTANCE;
    }

    public CustomerRepository() {
    	super();

    	// this.customerByName = new Map<String, Customer>();

    	// final Customer customer1 = new Customer("Alice", "123");
    	// customerByName.put(customer1.getUserName(), customer1);

    	// final Customer customer2 = new Customer("Bob", "123");
    	// customerByName.put(customer2.getUserName(), customer2);
    }

    public Customer findByName(String name) {
    	return null;
    }
}
