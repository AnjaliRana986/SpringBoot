package com.anjali.rest.websevices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    //implement methods for a specific user service
    //store all the details in the database . and need JPA/Hibernate talk to the database
    //for now create static list ans UserDaoService to talk to the static list
    //UserDaoService > static list
    private  static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3,"Jim", LocalDate.now().minusYears(20)));
    }

    private List<User> findAll(){
        return users;
    }
}
