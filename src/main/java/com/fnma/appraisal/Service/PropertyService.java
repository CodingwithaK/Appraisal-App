package com.fnma.appraisal.Service;

import com.fnma.appraisal.Entity.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getAllProperty();
    Property getPropertyByID(int propertyID);
    Property addProperty(Property property);
    Property updateProperty(Property property);
    String deletePropertyByID(int propertyID);
    
}
