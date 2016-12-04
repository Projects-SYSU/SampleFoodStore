package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thymeleafexamples.sfs.business.dao.OrderDao;
import thymeleafexamples.sfs.business.dao.OrderLineDao;
import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class OrderService {

	@Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderLineDao orderLineDao;

	public OrderService() {
		super();
	}

	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	public Order findById(final int id) {
		return orderDao.findOne(id);
	}

	public int addOrder(Order o) {
		Set<OrderLine> orderLines = o.getOrderLines();
		for (OrderLine ol : orderLines)
			orderLineDao.create(ol);
		orderDao.create(o);
		return o.getId();
	}
}