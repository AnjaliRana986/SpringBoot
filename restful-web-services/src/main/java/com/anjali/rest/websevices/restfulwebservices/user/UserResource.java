package com.anjali.rest.websevices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService service;
    public UserResource(UserDaoService service){
        this.service = service;
    }
    //retrieve detail of all users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    //retrieve detail for a specific user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        return service.findOne(id);
    }

    //need rest api client to fire post request
    //one of them talend API tester
    //Post /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User savedUser = service.save(user);
        //  location- /users/4 is the url is te user which is created
        //users/4 => /users/{id}, users.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
