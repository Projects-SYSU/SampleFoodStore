package thymeleafexamples.sfs.business.dao;

import java.util.List;
import java.util.ArrayList;

import thymeleafexamples.sfs.business.entities.Order;
import thymeleafexamples.sfs.business.entities.OrderLine;

import org.springframework.stereotype.Repository;

@Repository
public class OrderLineDaoImpl extends AbstractJpaDAO<OrderLine> implements OrderLineDao {
	public OrderLineDaoImpl() {
		super();

		setClazz(OrderLine.class);
	}
}