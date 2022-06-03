package com.fnma.appraisal.Service;

import com.fnma.appraisal.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserByID(int userID);
    User addUser(User user);
    User updateUser(User user);
    String deleteUserByID(int userID);
}
