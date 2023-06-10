package com.anjali.springboot.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value="login",method = RequestMethod.GET)     //spring MVC provide annotation requestmapping to map with url
    public String gotoLoginPage() {
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWecomePage() {
        return "welcome";
    }
}
