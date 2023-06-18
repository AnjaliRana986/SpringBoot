package com.anjali.rest.websevices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anjali.rest.websevices.restfulwebservices.user.User;
public interface UserRepository extends JpaRepository<User,Integer> {

}
