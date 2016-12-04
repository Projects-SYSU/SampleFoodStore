package thymeleafexamples.sfs.business.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
public class Customer implements Serializable {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    Set<Order> orders;

    private String salt;

    private boolean vip = false;

    public Customer() {
      super();
      this.orders = new HashSet<Order>();
    }

    public Customer(String username, String password) {
      super();
      this.orders = new HashSet<Order>();
      setUsername(username);
      setPassword(password);
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(final String username) {
      this.username = username;
    }

    public void setVip(boolean vip) {
      this.vip = vip;
    }

    public boolean getVip() {
      return this.vip;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(final String password) {
      this.password = password;
    }

    public Set<Order> getOrders() {
      return this.orders;
    }

    public String getSalt() {
      return this.salt;
    }

    public void setSalt(String salt) {
      this.salt = salt;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((username == null) ? 0 : username.hashCode());
      return result;
    }

    @Override
    public String toString() {
      final StringBuilder builder = new StringBuilder();
      builder.append("Customer [name=").append(username).append("]");
      return builder.toString();
    }
}
