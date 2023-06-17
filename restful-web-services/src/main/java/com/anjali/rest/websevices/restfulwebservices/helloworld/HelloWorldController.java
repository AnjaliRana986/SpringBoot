package com.anjali.rest.websevices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

//this controller will EXPOSE A REST API
//will give a specific url to the rest api
//task1 : creat simple rest api to return string back
//task 2: create rest api to return json back ( commonly rest api does)
@RestController
public class HelloWorldController {
    //hello-world
    //"Hello -world
//    @RequestMapping(method = RequestMethod.GET, path ="/hello-world" )
    // A better way to do this mapping
    private MessageSource messageSource;
    public HelloWorldController(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    @GetMapping( path ="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    //task 2
    @GetMapping( path ="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("Hello World");
    }

    //Path Parameters ( is the variable in the url)
    // and to be able to capture the value fo path parameters we will use @PathVariable annotation
    @GetMapping( path ="/hello-world/path-variable/{name}")   //{} indicates that name is a variable
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello World, %s",name));
    }

    @GetMapping( path ="/hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//        return "Hello World";
    }
}
