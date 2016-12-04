package thymeleafexamples.sfs.business.services;

import thymeleafexamples.sfs.business.entities.Customer;
import thymeleafexamples.sfs.business.dao.CustomerDao;

import java.util.List;

public interface CustomerService {

  public List<Customer> findAll();

  public Customer findByName(final String name);

  public void create(Customer cs);
}
