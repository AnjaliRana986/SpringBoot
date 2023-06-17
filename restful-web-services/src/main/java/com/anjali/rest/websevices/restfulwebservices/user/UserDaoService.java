package com.anjali.rest.websevices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //implement methods for a specific user service
    //store all the details in the database . and need JPA/Hibernate talk to the database
    //for now create static list ans UserDaoService to talk to the static list
    //UserDaoService > static list
    private  static List<User> users = new ArrayList<>();
    private  static  int usersCount  = 0;

    static {
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);

//        return users.stream().filter(predicate).findFirst().get();
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public void deleteByID(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
//        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
