package com.oldtownbarber.user_service.service;

import com.oldtownbarber.user_service.exception.UserException;
import com.oldtownbarber.user_service.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id) throws UserException;

    List<User> getAllUsers();

    User updateUser(Long id, User user) throws UserException;

    void deleteUser(Long id) throws UserException;

}
