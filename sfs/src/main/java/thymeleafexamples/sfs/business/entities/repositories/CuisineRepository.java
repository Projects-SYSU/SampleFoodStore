package thymeleafexamples.sfs.business.entities.repositories;

import org.springframework.stereotype.Repository;
import thymeleafexamples.sfs.business.entities.Cuisine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shower on 16-11-7.
 */
@Repository
public class CuisineRepository {
    private final Map<String, Cuisine> cuisineByName;
    private static final CuisineRepository INSTANCE = new CuisineRepository();

    public static CuisineRepository getInstance() {
        return INSTANCE;
    }

    public CuisineRepository() {
        super();

        cuisineByName = new HashMap<String, Cuisine>();

        final Cuisine cuisine1 = new Cuisine();
        cuisine1.setcuisineName("Hamburger");
        cuisine1.setDescription("delicious hamburger");
        cuisine1.setDiscount(0.0);
        cuisine1.setPrice(6.0);
//        cuisine1.setImagePath("../../images/hamburger.jpg");
        cuisineByName.put(cuisine1.getCuisineName(), cuisine1);

        final Cuisine cuisine2 = new Cuisine();
        cuisine2.setcuisineName("Salad");
        cuisine2.setDescription("delicious Salad");
        cuisine2.setDiscount(0.9);
        cuisine2.setPrice(8.0);
//        cuisine1.setImagePath("../../images/salad.jpg");
        cuisineByName.put(cuisine2.getCuisineName(), cuisine2);

        final Cuisine cuisine3 = new Cuisine();
        cuisine3.setcuisineName("Noodles");
        cuisine3.setDescription("delicious Noodles");
        cuisine3.setDiscount(0.8);
        cuisine3.setPrice(10.0);
//        cuisine1.setImagePath("../../images/noodles.jpg");
        cuisineByName.put(cuisine3.getCuisineName(), cuisine3);
    }

    public List<Cuisine> findAll() {
        return new ArrayList<Cuisine>(this.cuisineByName.values());
    }

    public Cuisine findByName(final String name) {
        return this.cuisineByName.get(name);
    }
}
