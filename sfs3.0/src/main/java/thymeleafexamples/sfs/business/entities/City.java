package thymeleafexamples.sfs.business.entities;

import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class City implements Serializable {
	@Column(nullable = false)
	private String name;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})  
    @JoinColumn(name = "cuisine_id") 
	private Set<Cuisine> cuisines;

	public City() {
		super();

		this.cuisines = new HashSet<Cuisine>();
	}

	public City(String name) {
		super();
		this.name = name;

		this.cuisines = new HashSet<Cuisine>();
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

	public void setCuisines(final Set<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("City [name=").append(name).append("]");
        return builder.toString();
    }

}