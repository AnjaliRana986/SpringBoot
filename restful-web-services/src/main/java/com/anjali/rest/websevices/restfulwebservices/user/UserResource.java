package com.anjali.rest.websevices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<User> retrieveUser(@PathVariable int id){

        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<User>entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this
                .getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all - users"));
        return entityModel;
    }
    @DeleteMapping ("/users/{id}")
    public void deleteUser(@PathVariable int id){

        service.deleteByID(id);

    }

    //need rest api client to fire post request
    //one of them talend API tester
    //Post /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

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
