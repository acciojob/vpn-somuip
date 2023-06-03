package com.driver.services;

import com.driver.model.User;

public interface UserService {

    public void register(String username, String password, String countryName) throws Exception;

    public void subscribe(Integer userId, Integer serviceProviderId);
}
