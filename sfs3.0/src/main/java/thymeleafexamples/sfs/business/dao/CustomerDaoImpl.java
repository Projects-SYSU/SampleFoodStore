package thymeleafexamples.sfs.business.dao;

import java.util.List;
import java.util.ArrayList;

import thymeleafexamples.sfs.business.entities.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends AbstractJpaDAO<Customer> implements CustomerDao {
	public CustomerDaoImpl() {
		super();

		setClazz(Customer.class);
	}
}