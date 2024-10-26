package com.map.rute.data.dao;
import java.util.List;
import java.util.UUID;

public interface UserDAO {
    User getUserById(UUID id);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(UUID id);
}

