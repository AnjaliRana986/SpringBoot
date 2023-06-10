package com.anjali.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());
    //http://localhost:8080/login?name=Anjali
    //Model ( whenever you want to pass from controller to jsp by putting it into model)
    @RequestMapping("/login")     //spring MVC provide annotation requestmapping to map with url

    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name",name);
//        logger.debug("Request param is {}",name);
//        System.out.println("Request Param is " + name);
        return "login";
    }
}
