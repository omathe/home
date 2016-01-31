package fr.free.omathe.home.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * A User is somebody who can access to the services.
 *
 * @author olivier MATHE
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_home", joinColumns = {
        @JoinColumn(name = "userId")}, inverseJoinColumns = {
        @JoinColumn(name = "homeId")})
    private Set<Home> homeSet;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public User(final String firstName, final String lastName, final String email, final String login, final String password) {
        super();
        Objects.requireNonNull(firstName, "firstName must be defined.");
        Objects.requireNonNull(lastName, "lastName must be defined.");
        Objects.requireNonNull(email, "email must be defined.");
        Objects.requireNonNull(login, "login must be defined.");
        Objects.requireNonNull(password, "password must be defined.");

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        Objects.requireNonNull(firstName, "firstName must be defined.");

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        Objects.requireNonNull(lastName, "lastName must be defined.");

        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        Objects.requireNonNull(email, "email must be defined.");

        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        Objects.requireNonNull(login, "login must be defined.");

        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        Objects.requireNonNull(password, "password must be defined.");

        this.password = password;
    }

    public Set<Home> getHomeSet() {
        if (homeSet == null) {
            homeSet = new HashSet();
        }
        return homeSet;
    }

    public void setHomeSet(final Set<Home> homeSet) {
        this.homeSet = homeSet;
    }

    public void addHome(final Home home) {
        Objects.requireNonNull(home, "home must be defined.");

        getHomeSet().add(home);
    }

    public void removeHome(final Home home) {
        Objects.requireNonNull(home, "home must be defined.");

        getHomeSet().remove(home);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    
    
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", homeSet=" + homeSet + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", login=" + login + ", password=" + password + '}';
    }

}
