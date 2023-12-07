package com.cursed.bjs.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DetailedUsers")
@Getter @Setter 
public class DetailedUsers {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "age")
    private Long age;

    @Column(name = "country_of_origin")
    private String country_of_origin;  
    
    protected DetailedUsers() {

    }

    public DetailedUsers(String username, String email, String first_name, String last_name, Long age, String country_of_origin) {

        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.country_of_origin = country_of_origin;

    }

    public Long getId() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCountryOfOrigin() {
        return country_of_origin;
    }

    public void setCountryOfOrigin(String country_of_origin) {
        this.country_of_origin = country_of_origin;
    }

    @Override
    public String toString() {
        return String.format("[%s - %s - %s - %s - %s - %s - %s]", id, username, email, first_name, last_name, age, country_of_origin);
    }

}
