package thymeleafexamples.sfs.business.entities;

import thymeleafexamples.sfs.business.entities.Cuisine;

import java.util.LinkedHashSet;
import java.util.Set;

public class City {
	private String name = null;
	private Integer id = null;
	private Set<Cuisine> cuisines = new LinkedHashSet<Cuisine>();

	public City() {
		super();
	}

	public City(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
        this.id = id;
    }

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Set<Cuisine> getCuisines() {
		return this.cuisines;
	}

}