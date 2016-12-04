package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import thymeleafexamples.sfs.business.entities.Customer;
import thymeleafexamples.sfs.business.dao.CustomerDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
  private CustomerDao customerDao;

  public List<Customer> findAll() {
    return customerDao.findAll();
  }

  public Customer findByName(final String name) {
    return customerDao.findOneByName(name);
  }

  public void create(Customer cs) {
    customerDao.create(cs);
  }
}
