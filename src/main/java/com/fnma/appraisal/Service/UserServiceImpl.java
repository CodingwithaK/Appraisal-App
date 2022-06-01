package com.fnma.appraisal.Service;

import com.fnma.appraisal.Dao.UserDao;
import com.fnma.appraisal.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao UserDao;

    @Override
    public List<User> getAllUsers() {
        return this.UserDao.findAll();
    }

    @Override
    public User getUserByID(int UserID) {
        Optional<User> c = this.UserDao.findById(UserID);
        User user = null;
        if(c.isPresent()){
            user = c.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + UserID);
        }
        return user;

    }

    @Override
    public User addUser(User user) {
        return this.UserDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return this.UserDao.save(user);
    }

    @Override
    public String deleteUserByID(int userID) {
        this.UserDao.deleteById(userID);
        return "Deleted Successfully";
    }
}
