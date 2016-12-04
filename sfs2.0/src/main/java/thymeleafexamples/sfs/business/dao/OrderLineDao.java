package thymeleafexamples.sfs.business.dao;

import java.util.List;

import thymeleafexamples.sfs.business.entities.OrderLine;

public interface OrderLineDao {

	public List<OrderLine> findAll();

	public OrderLine findOne(final int id);

	public void create(final OrderLine ol);
}