package thymeleafexamples.sfs.business.entities;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by shower on 16-11-7.
 */
public class Order {
    private Integer id;
    private Integer cityId;
    private Customer customer;
    private Set<OrderLine> orderLines = new LinkedHashSet<OrderLine>();

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }
}
