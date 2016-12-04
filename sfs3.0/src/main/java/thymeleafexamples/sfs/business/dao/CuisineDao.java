package thymeleafexamples.sfs.business.dao;

import java.util.List;

import thymeleafexamples.sfs.business.entities.Cuisine;

public interface CuisineDao {

	public List<Cuisine> findAll();

	public Cuisine findOne(final int id);

	public void create(final Cuisine cuisine);

	public void delete(final Cuisine cuisine);
}