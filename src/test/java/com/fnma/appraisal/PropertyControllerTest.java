package com.fnma.appraisal;
import com.fnma.appraisal.Dao.PropertyDao;
import com.fnma.appraisal.Entity.Property;
import com.fnma.appraisal.Service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doReturn;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyControllerTest {
    @Autowired
    private PropertyService propServ;

    @MockBean
    private PropertyDao propDao;

    @Test
    @DisplayName("Find by ID")
    void findByIDTest(){
        Property property = new Property(15,
                "Owner",
                "123 Street",
                "4456532185",
                "email@site.com",
                4,
                2,
                1400,
                20,
                new Date(),
                300000);

        doReturn(Optional.of(property)).when(propDao).findById(15);

        Optional<Property> returnedProp = Optional.ofNullable(propServ.getPropertyByID(15));

        Assertions.assertTrue(returnedProp.isPresent(), "Property was not found");
        Assertions.assertSame(returnedProp.get(), property, "The property returned was not the same as the mock");
    }

    @Test
    @DisplayName("Property Not Found")
    void propNotFoundTest(){
        Optional<Property> returnProp = Optional.empty();

        assertFalse(returnProp.isPresent(), "Property not found");
    }

    @Test
    @DisplayName("Get All")
    void getAllPropTest(){
        Property property = new Property(15,
                "Owner",
                "123 Street",
                "4456532185",
                "email@site.com",
                4,
                2,
                1400,
                20,
                new Date(),
                300000);
        Property property2 = new Property(15,
                "Owner2",
                "456 Street",
                "8798798798",
                "email2@site.com",
                5,
                3,
                1500,
                30,
                new Date(),
                350000);

        doReturn(Arrays.asList(property, property2)).when(propDao).findAll();

        List<Property> props = propServ.getAllProperty();

        Assertions.assertEquals(2, props.size(), "findAll should return 2 properties");
    }

    @Test
    @DisplayName("Test add property")
    void testSave() {
        Property property = new Property(15,
                "Owner",
                "123 Street",
                "4456532185",
                "email@site.com",
                4,
                2,
                1400,
                20,
                new Date(),
                300000);

        doReturn(property).when(propDao).save(property);

        // Execute the userService call
        Property returnedProp = propServ.addProperty(property);

        // Assert the response
        Assertions.assertNotNull(returnedProp, "The saved user should not be null");
        Assertions.assertEquals("Owner", returnedProp.getOwnerName(), "The owner name should be changed");
    }
}
