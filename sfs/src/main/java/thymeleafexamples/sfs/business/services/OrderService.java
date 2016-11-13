package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thymeleafexamples.sfs.business.entities.repositories.OrderRepository;
import thymeleafexamples.sfs.business.entities.Order;

import java.util.List;

@Service
public class OrderService {
	public OrderService() {
		super();
	}

	public List<Order> findAll() {
		return OrderRepository.getInstance().findAll();
	}
	
	public Order findById(final int id) {
		return OrderRepository.getInstance().findById(id);
	}

	public int addOrder(Order o) {
		return OrderRepository.getInstance().addOrder(o);
	}
}