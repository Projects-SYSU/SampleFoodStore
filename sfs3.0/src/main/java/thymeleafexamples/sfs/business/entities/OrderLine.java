package thymeleafexamples.sfs.business.entities;

import java.util.List;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

@Entity
public class OrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Cuisine cuisine;

    @Column(nullable = false)
    private Integer amount;
    private Double purchasePrice;

    public OrderLine() {
        super();
    }

    public OrderLine(Cuisine cuisine, Integer amount) {
        this.cuisine = cuisine;
        this.amount = amount;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((cuisine == null) ? 0 : cuisine.hashCode());
    //     return result;
    // }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("OrderLine [id=").append(id).append("]");
        return builder.toString();
    }
}
