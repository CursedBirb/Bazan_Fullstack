package com.cursed.bjs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MainController {

    @GetMapping("/getData")
    @ResponseBody
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @PostMapping("/sendData")
   public String receiveData(@RequestBody String data) {
       System.out.println("Received data: " + data);
       return "Data received: " + data;
   }
    

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
    
}
