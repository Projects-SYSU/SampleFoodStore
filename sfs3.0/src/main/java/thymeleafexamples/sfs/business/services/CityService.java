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
        if (isInit)
            return;
        isInit = true;
        City shanghai = new City("shanghai");
        cityDao.create(shanghai);

        Cuisine hamburger = new Cuisine("hamburger");
        hamburger.setImageName("hamburger.jpg");
        hamburger.setPrice(3.0);
        hamburger.setDiscount(0.1);
        hamburger.setDescription("blablabla");
        shanghai.getCuisines().add(hamburger);

        Cuisine noodle = new Cuisine("noodles");
        noodle.setPrice(10.0);
        noodle.setDiscount(0.9);
        noodle.setDescription("hahahha");
        noodle.setImageName("noodles.jpg");
        shanghai.getCuisines().add(noodle);


        cuisineDao.create(hamburger);
        cuisineDao.create(noodle);
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