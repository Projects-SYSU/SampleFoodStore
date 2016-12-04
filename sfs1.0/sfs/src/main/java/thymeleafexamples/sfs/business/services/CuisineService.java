package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleafexamples.sfs.business.entities.Cuisine;
import thymeleafexamples.sfs.business.entities.repositories.CuisineRepository;

import java.util.List;

/**
 * Created by shower on 16-11-7.
 */
@Service
public class CuisineService {

    public CuisineService() {
        super();
    }

    public List<Cuisine> findAll() {
        return CuisineRepository.getInstance().findAll();
    }

    public Cuisine findByName(final String name) {
        return CuisineRepository.getInstance().findByName(name);
    }
}
