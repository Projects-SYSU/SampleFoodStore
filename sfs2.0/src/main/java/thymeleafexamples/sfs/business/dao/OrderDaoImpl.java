package thymeleafexamples.sfs.business.dao;

import java.util.List;
import java.util.ArrayList;

import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends AbstractJpaDAO<Order> implements OrderDao {
	public OrderDaoImpl() {
		super();

		setClazz(Order.class);
	}
}