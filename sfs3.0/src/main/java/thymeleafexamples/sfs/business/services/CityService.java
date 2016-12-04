 package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import thymeleafexamples.sfs.business.entities.*;
import thymeleafexamples.sfs.business.dao.CityDao;
import thymeleafexamples.sfs.business.dao.CuisineDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class CityService {

    private CityDao cityDao;
    private CuisineDao cuisineDao;
    private static boolean isInit = false;

    @Autowired
    public CityService(CityDao cityDao, CuisineDao cuisineDao) {
    	super();
        this.cityDao = cityDao;
        this.cuisineDao = cuisineDao;
    }

    private void init() {
        if (isInit) return;
        isInit = true;

        //  city shanghai
        City shanghai = new City("shanghai");
        cityDao.create(shanghai);

        Cuisine hamburger = new Cuisine("hamburger");
        hamburger.setImageName("hamburger.jpg");
        hamburger.setPrice(10.0);
        hamburger.setDiscount(0.9);
        hamburger.setDescription("this is a hamburger");
        shanghai.getCuisines().add(hamburger);

        Cuisine noodle = new Cuisine("noodles");
        noodle.setPrice(16.0);
        noodle.setDiscount(0.7);
        noodle.setDescription("the is noodles");
        noodle.setImageName("noodles.jpg");
        shanghai.getCuisines().add(noodle);


        // city guangzhou
        City guangzhou = new City("guangzhou");
        cityDao.create(guangzhou);

        Cuisine salad = new Cuisine("salad");
        salad.setImageName("salad.jpg");
        salad.setPrice(20.0);
        salad.setDiscount(0.8);
        salad.setDescription("this is salad");
        guangzhou.getCuisines().add(salad);

        Cuisine noodle2 = new Cuisine("noodles");
        noodle2.setPrice(20.0);
        noodle2.setDiscount(0.5);
        noodle2.setDescription("this is noodles");
        noodle2.setImageName("noodles.jpg");
        guangzhou.getCuisines().add(noodle2);

        cuisineDao.create(hamburger);
        cuisineDao.create(noodle);
        cuisineDao.create(salad);
        cuisineDao.create(noodle2);
    }

    public List<City> findAll() {
        init();
        return cityDao.findAll();
    }

    @Cacheable("city")
    public City findById(final Integer id) {
        init();
        return cityDao.findOne(id);
    }
}