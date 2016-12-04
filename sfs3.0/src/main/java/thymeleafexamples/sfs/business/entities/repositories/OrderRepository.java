package thymeleafexamples.sfs.business.entities.repositories;

import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
	private static final OrderRepository INSTANCE = new OrderRepository();
	private List<Order> orders;

	public static OrderRepository getInstance() {
        return INSTANCE;
    }

    public OrderRepository() {
    	super();

    	orders = new ArrayList<Order>();
    }

    public List<Order> findAll() {
    	return orders;
    }

    public Order findById(final int id) {
    	if (orders.size() <= id + 1)
    		return orders.get(id);
    	return null;
    }

    public int addOrder(Order o) {
    	orders.add(o);
    	return orders.size() - 1;
    }
}