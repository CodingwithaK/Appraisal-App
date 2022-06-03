package com.fnma.appraisal.Controller;

import com.fnma.appraisal.Entity.Property;
import com.fnma.appraisal.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    // Property API

    @GetMapping ("/propertys")
    public List<Property> getAllProperty(){
        return this.propertyService.getAllPropertys();
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
}
