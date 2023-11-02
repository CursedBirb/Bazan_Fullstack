package com.cursed.bjs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.ui.Model;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class MainController {

    @RequestMapping("/powitanie")
    public String greeting(@RequestParam(value="myname", required=false, defaultValue="nieznany") String myname, Model model) {
        
        model.addAttribute("name", myname); //Dodanie atrybutu do lokalnej pamieci tzw. modelu
        
        return "powitanie"; //Przekierowanie do strony powitanie.html
    }

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
    

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
    
}
