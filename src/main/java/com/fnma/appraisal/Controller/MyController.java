package com.fnma.appraisal.Controller;

import com.fnma.appraisal.Entity.Appraisal;
import com.fnma.appraisal.Entity.Property;
import com.fnma.appraisal.Entity.User;
import com.fnma.appraisal.Service.AppraisalService;
import com.fnma.appraisal.Service.PropertyService;
import com.fnma.appraisal.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private AppraisalService appraisalService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;



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

    // Appraisal API
    @GetMapping ("/appraisals")
    public List<Appraisal> getAllAppraisals(){
        return this.appraisalService.getAllAppraisal();
    }
    @GetMapping("/appraisals/{appraisalID}")
    public Appraisal getappraisal(@PathVariable String appraisalID){
        return this.appraisalService.getAppraisalByID(Integer.parseInt(appraisalID));
    }
    @PostMapping("/appraisals")
    public Appraisal addappraisal(@RequestBody Appraisal appraisal){
        return this.appraisalService.addAppraisal(appraisal);
    }
    @PutMapping("/appraisals")
    public Appraisal updateappraisal(@RequestBody Appraisal appraisal){
        return this.appraisalService.updateAppraisal(appraisal);
    }
    @DeleteMapping("/appraisals/{appraisalID}")
    public String deleteappraisal(@PathVariable String appraisalID){
        return this.appraisalService.deleteAppraisalByID(Integer.parseInt(appraisalID));
    }
    
    // Property API

    @GetMapping ("/propertys")
    public List<Property> getAllPropertys(){
        return this.propertyService.getAllProperty();
    }
    @GetMapping("/propertys/{propertyID}")
    public Property getproperty(@PathVariable String propertyID){
        return this.propertyService.getPropertyByID(Integer.parseInt(propertyID));
    }
    @PostMapping("/propertys")
    public Property addproperty(@RequestBody Property property){
        return this.propertyService.addProperty(property);
    }
    @PutMapping("/propertys")
    public Property updateproperty(@RequestBody Property property){
        return this.propertyService.updateProperty(property);
    }
    @DeleteMapping("/propertys/{propertyID}")
    public String deleteproperty(@PathVariable String propertyID){
        return this.propertyService.deletePropertyByID(Integer.parseInt(propertyID));
    }

    // User API

    @GetMapping ("/users")
    public List<User> getUser(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/users/{userID}")
    public User getuser(@PathVariable String userID){
        return this.userService.getUserByID(Integer.parseInt(userID));
    }
    @PostMapping("/users")
    public User adduser(@RequestBody User user){
        return this.userService.addUser(user);
    }
    @PutMapping("/users")
    public User updateuser(@RequestBody User user){
        return this.userService.updateUser(user);
    }
    @DeleteMapping("/users/{userID}")
    public String deleteuser(@PathVariable String userID){
        return this.userService.deleteUserByID(Integer.parseInt(userID));
    }
}
