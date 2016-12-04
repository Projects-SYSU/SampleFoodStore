package thymeleafexamples.sfs.business.dao;

import java.util.List;

import thymeleafexamples.sfs.business.entities.Customer;

public interface CustomerDao {

	public List<Customer> findAll();

	public Customer findOneByName(final String name);

	public void create(final Customer customer);
}