package com.anjali.springboot.todowebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  //spring manages this as a web request controller
public class SayHelloController {
    //"say--hello" =>"Hello !what are you learning today?"
    //say-hello
    //http://localhost:8080/say-hello

    //create a method returning a string back
    @RequestMapping("/say-hello")     //spring MVC provide annotation requestmapping to map with url
    @ResponseBody
    public String sayHello() {
        return "Hello !what are you learning today?";
    }
    @RequestMapping("/say-hello-html")     //spring MVC provide annotation requestmapping to map with url
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }


    //view technology -> JSP
    //create a view using JSP in next
    //create a sayHello.jsp file
    //"say-hello-jsp"-> say hello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    //   /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
    // /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
    @RequestMapping("/say-hello-jsp")     //spring MVC provide annotation requestmapping to map with url

    public String sayHelloJsp() {
        return "sayHello";
    }
}
