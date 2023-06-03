package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin registerAdmin(String username, String password) {

        Admin admin = new Admin();
        admin.setName(username);
        admin.setPassword(password);

        return adminRepository1.save(admin);
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
        ServiceProvider serviceProvider = new ServiceProvider();
        for(ServiceProvider serviceProvider1 : serviceProviderRepository1.findAll()) {
            serviceProvider1.getName().equals(providerName);
            serviceProvider = serviceProvider1;
        }
        Admin admin = adminRepository1.findById(adminId).get();
        admin.getServiceProviderList().add(serviceProvider);
        return adminRepository1.save(admin);
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception {
        ServiceProvider serviceProvider = serviceProviderRepository1.findById(serviceProviderId).get();
        if (!countryName.equals("IND") || !countryName.equals("USA") || !countryName.equals("AUS") || !countryName.equals("CHI") || !countryName.equals("JPN")) {
            throw new Exception("Country not found");
        }

        return serviceProvider;
    }
}
