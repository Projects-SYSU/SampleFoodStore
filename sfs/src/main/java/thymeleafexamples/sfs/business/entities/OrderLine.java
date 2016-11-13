package thymeleafexamples.sfs.business.entities;

/**
 * Created by shower on 16-11-7.
 */
public class OrderLine {
    private String cuisineName = null;
    private Integer amount = null;
    private Double purchasePrice = null;

    public OrderLine() {
        super();
    }

    public OrderLine(String cuisineName, Integer amount) {
        this.cuisineName = cuisineName;
        this.amount = amount;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
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
}
