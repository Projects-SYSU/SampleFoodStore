package thymeleafexamples.sfs.business.entities;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Table;

@Entity
@Table(name="order_sfs")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private City city;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})  
    @JoinColumn(name = "ols_id")
    private Set<OrderLine> orderLines;

    public Order() {
        super();
    }

    public Order(City city) {
        super();

        this.orderLines = new HashSet<OrderLine>();
        this.city = city;
    }

    public Order(City city, Customer customer) {
        super();

        this.orderLines = new HashSet<OrderLine>();
        this.city = city;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
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

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Order [id=").append(id).append("]");
        return builder.toString();
    }
}
