package thymeleafexamples.sfs.business.entities;

/**
 * Created by shower on 16-11-7.
 */
public class Cuisine {
    private String cuisineName = null;
    private String description = null;
    private Double price = null;
    private Double discount = null;
    private String imagePath = null;

    public Cuisine() {
        super();
    }

    public Cuisine(final String cuisineName, final String description, final Double price, final Double discount, final String imagePath) {
        super();
        this.cuisineName = cuisineName;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.imagePath = imagePath;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setcuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
