package com.anjali.rest.websevices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Versioning REST API
//URI Versioning
//Request Parameter versioning
//Custom header versioning

@RestController
public class VersioningPersonController {

    @GetMapping(value = "/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    //request parameter
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("Bob Charlie");
    }
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Bob","Charlie"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){

        return new PersonV1("Bob Charlie");
    }
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondtVersionOfPersonRequestHeader(){

        return new PersonV2(new Name("Bob","Charlie"));
    }

    //media type versioning
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){

        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){

        return new PersonV2(new Name("Bob","Charlie"));
    }
}
