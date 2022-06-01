package com.fnma.appraisal;

import com.fnma.appraisal.Dao.UserDao;
import com.fnma.appraisal.Entity.User;
import com.fnma.appraisal.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    @DisplayName("Test getById Success")
    void testFindById() {
        // Setup our mock userDao
        User user = new User(11,"First Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","user","password","Bank","ROLE_BANK");
        doReturn(Optional.of(user)).when(userDao).findById(11);

        // Execute the userService call
        Optional<User> returnedUser = Optional.ofNullable(userService.getUserByID(11));

        // Assert the response
        Assertions.assertTrue(returnedUser.isPresent(), "User was not found");
        Assertions.assertSame(returnedUser.get(), user, "The user returned was not the same as the mock");
    }
    @Test
    @DisplayName("Test getById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock userDao
        doReturn(Optional.empty()).when(userDao).findById(13);

        // Execute the userService call
        Optional<User> returnedUser = Optional.ofNullable(userService.getUserByID(13));

        // Assert the response
        Assertions.assertFalse(returnedUser.isPresent(), "User should not be found");
    }

    @Test
    @DisplayName("Test get all")
    void testFindAll() {
        // Setup our mock userDao
        User user1 = new User(11,"First Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","user","password","Bank","ROLE_BANK");
        User user2 = new User(12,"Second Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","user","password","Bank","ROLE_BANK");
        doReturn(Arrays.asList(user1, user2)).when(userDao).findAll();

        // Execute the userService call
        List<User> users = userService.getAllUsers();

        // Assert the response
        Assertions.assertEquals(2, users.size(), "findAll should return 2 users");
    }

    @Test
    @DisplayName("Test add user")
    void testSave() {
        // Setup our mock userDao
        User user = new User(11,"First Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK");
        doReturn(user).when(userDao).save(user);

        // Execute the userService call
        User returnedUser = userService.addUser(user);

        // Assert the response
        Assertions.assertNotNull(returnedUser, "The saved user should not be null");
        Assertions.assertEquals("bob", returnedUser.getUserName(), "The user name should be changed");
    }
}

