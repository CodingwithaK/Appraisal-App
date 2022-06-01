package com.fnma.appraisal.Config;

import com.fnma.appraisal.Dao.UserDao;
import com.fnma.appraisal.Entity.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public ApplicationRunner loadUserData(UserDao userDao) {
        List<User> users = Arrays.asList(
                new User(11,"First Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(12,"Second Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(13,"Third Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(14,"Fourth Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(15,"Fifth Third Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK")
        );
        return (args) -> {
            userDao.saveAll(users);
        };
    }
}
