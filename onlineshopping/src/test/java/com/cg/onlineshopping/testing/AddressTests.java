package com.cg.onlineshopping.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineshopping.entities.Address;
import com.cg.onlineshopping.repository.AddressRepository;
import com.cg.onlineshopping.service.AddressService;


 

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTests {

 

    @Autowired
    AddressService addressService;
    @MockBean
    AddressRepository addRepo;
    
    @Test
    public void testAddCustomer()
    {
        Address add = new Address();
        add.setAddressId(1001);
        add.setBuildingName"abc"();
        cust.setCity("Pune");
        cust.setState("Maharashtra");
        cust.setCountry("India");
        cust.setPincode("411038");
        
        Mockito.when(addressRepo.save(add)).thenReturn(add);
        assertThat(addressService.addCustomer(add)).isEqualTo(add);
    }
    @Test
    public void testDeleteCustomer()
    {
        Customer cust = new Customer();
        cust.setFirstName("Ayush");
        cust.setLastName("Sukla");
        cust.setMobileNumber("90385857");
        cust.setAddress("Mumbai");
        cust.setEmail("ayz@g.com");
        //Mockito.when(customerRepo.findById(1)).thenReturn(cust);
        Mockito.when(customerRepo.existsById(cust.getCustomerId())).thenReturn(false);
       assertFalse(customerRepo.existsById(cust.getCustomerId()));
    }
    @Test
    public void testUpdateCustomer()
    {
        Customer cust = new Customer();
        cust.setFirstName("Ayush");
        cust.setLastName("Sukla");
        cust.setMobileNumber("90385857");
        cust.setAddress("Mumbai");
        cust.setEmail("ayz@g.com");
        Mockito.when(customerRepo.save(cust)).thenReturn(cust);
        
        cust.setEmail("XYZ@g.com");
        assertThat(customerService.updateCustomer(cust)).isEqualTo(cust);
        
    }
    @Test
    public void testViewCustomer()
    {
        Customer cust = new Customer();
        //cust.setCustomerId(1003);
        cust.setFirstName("Ayush");
        cust.setLastName("Sukla");
        cust.setMobileNumber("90385857");
        cust.setAddress("Mumbai");
        cust.setEmail("ayz@g.com");
        Mockito.when(customerRepo.save(cust)).thenReturn(cust);
        assertThat(customerService.viewCustomer(cust.getCustomerId())).isEqualTo(cust);
        
    }
    @Test
    public void testViewAllCustomer()
    {
        List<Customer> cust = new ArrayList<>();
        Mockito.when(customerRepo.findAll()).thenReturn(cust);
        Exception ex = assertThrows(CustomerNotFoundException.class, ()-> customerService.viewAllCustomer());
        assertEquals("No Customer Found", ex.getMessage());
        
    }
}
  


