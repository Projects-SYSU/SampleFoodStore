package thymeleafexamples.sfs.business.entities;

/**
 * Created by shower on 16-11-7.
 */
public class Customer {
    private String username = null;
    private String password = null;

    private Customer() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
