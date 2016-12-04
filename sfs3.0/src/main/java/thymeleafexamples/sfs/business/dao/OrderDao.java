package thymeleafexamples.sfs.business.dao;

import java.util.List;

import thymeleafexamples.sfs.business.entities.Order;

public interface OrderDao {

	public List<Order> findAll();

	public Order findOne(final int id);

	public void create(final Order order);
}