package com.anjali.rest.websevices.restfulwebservices.user;

import com.anjali.rest.websevices.restfulwebservices.jpa.PostRepository;
import com.anjali.rest.websevices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserRepository repository;

    private PostRepository postRepository;
    public UserJpaResource( UserRepository repository, PostRepository postRepository){

        this.postRepository = postRepository;
        this.repository = repository;
    }
    //retrieve detail of all users
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){

        return repository.findAll();
    }
    //retrieve detail for a specific user
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<User>entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this
                .getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all - users"));
        return entityModel;
    }
    @DeleteMapping ("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){

        repository.deleteById(id);

    }
    @GetMapping ("/jpa/users/{id}/posts")
    public List<Post> retrievePostForUser(@PathVariable int id){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        return user.get().getPosts();

    }

    //need rest api client to fire post request
    //one of them talend API tester
    //Post /users
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User savedUser = repository .save(user);
        //  location- /users/4 is the url is te user which is created
        //users/4 => /users/{id}, users.getID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping  ("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:" + id);
        }
        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }


}
