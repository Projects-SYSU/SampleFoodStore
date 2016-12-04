package thymeleafexamples.sfs.business.dao;

import java.util.List;
import java.util.ArrayList;

import thymeleafexamples.sfs.business.entities.City;
import thymeleafexamples.sfs.business.entities.Cuisine;

import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl extends AbstractJpaDAO<City> implements CityDao {
	
	public CityDaoImpl() {
		super();

		setClazz(City.class);
	}
}