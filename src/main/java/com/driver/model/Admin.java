package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String password;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    List<ServiceProvider> serviceProviderList = new ArrayList<>();

    public Admin() {
    }

    public Admin(int id, String name, String password, List<ServiceProvider> serviceProviderList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.serviceProviderList = serviceProviderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }
}
