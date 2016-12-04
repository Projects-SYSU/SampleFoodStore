package thymeleafexamples.sfs.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleafexamples.sfs.business.entities.Cuisine;
import thymeleafexamples.sfs.business.dao.CuisineDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CuisineService {

	@Autowired
    private CuisineDao cuisineDao;

    public CuisineService() {
        super();
    }

    public List<Cuisine> findAll() {
        return cuisineDao.findAll();
    }

    public Cuisine findById(final int id) {
        return cuisineDao.findOne(id);
    }
}
