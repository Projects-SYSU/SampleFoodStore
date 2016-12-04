package thymeleafexamples.sfs.business.entities.repositories;

import org.springframework.stereotype.Repository;
import thymeleafexamples.sfs.business.entities.City;
import thymeleafexamples.sfs.business.entities.Cuisine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CityRepository {
	private static final CityRepository INSTANCE = new CityRepository();
	private final Map<Integer, City> citiesById;

	public static CityRepository getInstance() {
        return INSTANCE;
    }

	public CityRepository() {
		super();

		this.citiesById = new LinkedHashMap<Integer, City>();

		final City city1 = new City(1, "New York");
		city1.getCuisines().add(CuisineRepository.getInstance().findByName("Hamburger"));
		city1.getCuisines().add(CuisineRepository.getInstance().findByName("Salad"));
		this.citiesById.put(1, city1);
		
		final City city2 = new City(2, "ShangHai");
		city2.getCuisines().add(CuisineRepository.getInstance().findByName("Noodles"));
		city2.getCuisines().add(CuisineRepository.getInstance().findByName("Salad"));
		this.citiesById.put(2, city2);
	}

	public List<City> findAll() {
		return new ArrayList<City>(this.citiesById.values());
	}

	public City findById(final Integer id) {
        return this.citiesById.get(id);
    }
}