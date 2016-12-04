 package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleafexamples.sfs.business.entities.City;
import thymeleafexamples.sfs.business.entities.repositories.CityRepository;

import java.util.List;

@Service
public class CityService {

    public CityService() {
    	super();
    }

    public List<City> findAll() {
        return CityRepository.getInstance().findAll();
    }

    public City findById(final Integer id) {
        return CityRepository.getInstance().findById(id);
    }
}