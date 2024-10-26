package com.map.rute.data.service.impl;

import com.map.rute.data.dao.UserDAO;
import com.map.rute.data.models.User;
import com.map.rute.data.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(UUID id) {
        return userDAO.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(UUID id) {
        userDAO.deleteUser(id);
    }
}
