package thymeleafexamples.sfs.business.dao;

import java.util.List;

import thymeleafexamples.sfs.business.entities.City;

public interface CityDao {

	public List<City> findAll();

	public City findOne(final int id);

	public void create(final City city);
}