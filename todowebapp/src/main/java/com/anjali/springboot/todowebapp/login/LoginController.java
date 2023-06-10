package com.anjali.springboot.todowebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value="login",method = RequestMethod.GET)     //spring MVC provide annotation requestmapping to map with url
    public String gotoLoginPage() {
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWecomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name",name);
        model.put("password",password);
        return "welcome";
    }
}
