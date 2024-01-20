package controllers.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "HASHEDPASSWORD")
    private String hashedPassword;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACTIVE")
    private int active;

    @ManyToMany
    private Set<Roles> roles;
    
    protected Users() {

        this.email = null;
        this.hashedPassword = null;
        this.active = 0;
        roles = new HashSet<Roles>();

    }

    public Users(String username, String hashedPassword, String email, int active) {

        this.username = username;
        this.hashedPassword = hashedPassword;
        this.email = email.toLowerCase();
        this.active = active;

        roles = new HashSet<Roles>();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getEmail() {
        return email.toLowerCase();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s - %s]", username, hashedPassword, email, active, roles);
    }

}
