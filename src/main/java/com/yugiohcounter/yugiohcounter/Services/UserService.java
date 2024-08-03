package com.yugiohcounter.yugiohcounter.Services;

import com.yugiohcounter.yugiohcounter.Entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);

}
