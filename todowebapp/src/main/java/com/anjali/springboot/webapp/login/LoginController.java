package com.anjali.springboot.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    private  AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    @RequestMapping(value="login",method = RequestMethod.GET)     //spring MVC provide annotation requestmapping to map with url
    public String gotoLoginPage() {
        return "login";
    }
    @RequestMapping(value="login",method = RequestMethod.POST)
    public String gotoWecomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if(authenticationService.authenticate(name,password)){
            model.put("name",name);
            model.put("password",password);
            return "welcome";
        }
        // if not valid
        model.put("errorMesage", "Invalid Credentials ! Please try again. " );
        return "login";
    }
}