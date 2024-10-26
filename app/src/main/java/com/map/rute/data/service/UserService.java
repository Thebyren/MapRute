package com.map.rute.data.service;
import com.map.rute.data.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(UUID id);
}

