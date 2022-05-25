package com.fnma.appraisal.Service;

import com.fnma.appraisal.Dao.PropertyDao;
import com.fnma.appraisal.Entity.Property;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyDao PropertyDao;

    @Override
    public List<Property> getAllProperty() {
        return this.PropertyDao.findAll();
    }

    @Override
    public Property getPropertyByID(int PropertyID) {
        Optional<Property> c = this.PropertyDao.findById(PropertyID);
        Property property = null;
        if(c.isPresent()){
            property = c.get();
        } else {
            throw new RuntimeException(" Property not found for id :: " + PropertyID);
        }
        return property;

    }

    @Override
    public Property addProperty(Property property) {
        return this.PropertyDao.save(property);
    }

    @Override
    public Property updateProperty(Property property) {
        return this.PropertyDao.save(property);
    }

    @Override
    public String deletePropertyByID(int propertyID) {
        this.PropertyDao.deleteById(propertyID);
        return "Deleted Successfully";
    }
}
