package com.fnma.appraisal.Config;

import com.fnma.appraisal.Dao.AppraisalDao;
import com.fnma.appraisal.Dao.PropertyDao;
import com.fnma.appraisal.Dao.UserDao;
import com.fnma.appraisal.Entity.Appraisal;
import com.fnma.appraisal.Entity.Property;
import com.fnma.appraisal.Entity.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.AUTO;

@Configuration
public class AppConfig {
    @Bean
    public ApplicationRunner loadAppraisalData(AppraisalDao appraisalDao, UserDao userDao, PropertyDao propertyDao) {
        List<User> users = Arrays.asList(
                new User(1,"First Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(2,"Second Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(3,"Third Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(4,"Fourth Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(5,"Fifth Third Bank of Podunk","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(6,"Dukes Appraisals","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(7,"Stans Appraisals","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(8,"Pauls Appraisals","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(9,"Curts Appraisals","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK"),
                new User(10,"Chucks Appraisals","asdfasdf","1231231234","asdf@asdf.com","bob","password","Bank","ROLE_BANK")
        );
        List<Property> properties = Arrays.asList(
                new Property(11,"Jim Bob","1234 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000),
                new Property(12,"Joe Bob","1235 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000),
                new Property(13,"Sally Bob","1236 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000),
                new Property(14,"Chuck Bob","1237 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000),
                new Property(15,"Sandy Bob","1238 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000),
                new Property(16,"Paul Bob","1239 some stree Podunk TN","3453453456","asdf@asdf.com",10,4,10000,2,new Date(10/21/1923), 250000)
        );
        List<Appraisal> appraisals = Arrays.asList(
                new Appraisal(
                        17,
                        properties.get(0),
                        users.get(0),
                        users.get(5),
                        "completed",
                        new Date(),
                        new HashSet(Arrays.asList(
                                properties.get(0),
                                properties.get(1)
                                )
                        ),
                        "Crazy Neighbors",
                        (float)43.02
                ),
                new Appraisal(
                        18,
                        properties.get(3),
                        users.get(1),
                        users.get(6),
                        "completed",
                        new Date(),
                        new HashSet(Arrays.asList(
                                properties.get(4),
                                properties.get(5)
                                )
                        ),
                        "Crazy Neighbors",
                        (float)43.02
                )
        );
        return (args) -> {
            userDao.saveAll(users);
            propertyDao.saveAll(properties);
            appraisalDao.saveAll(appraisals);
        };
    }
}
