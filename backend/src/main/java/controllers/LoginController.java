package controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(
            maxAge = 3600
            )
@RestController
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "You need to be logged to process further";
    }

    
    
}
