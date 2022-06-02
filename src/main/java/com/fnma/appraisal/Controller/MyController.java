package com.fnma.appraisal.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/appraiser")
    public String sayHelloA(){
        return"welcome to my app appraiser";
    }
    @RequestMapping("/banker")
    public String sayHelloB(){
        return"welcome to my app banker";
    }
    @GetMapping("/")
    public String home(){
        return "<HTML><H1>Welcome to Appraisal Application</H1></HTML>";
    }

}
