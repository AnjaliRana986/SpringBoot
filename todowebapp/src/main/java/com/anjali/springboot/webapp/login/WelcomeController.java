package com.anjali.springboot.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)     //spring MVC provide annotation requestmapping to map with url
    public String gotoWelcomePage(ModelMap model) {
        model.put("name","anjali");
        return "welcome";
    }

}
