package my.AleksanderMroz.Demo.DAOTests;


import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Transactional
public class BasicDAOTests {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CourierRepository courierRepo;

    @Autowired
    OpinionRepository opinionRepo;

    @Autowired
    OutpostRepository outpostRepo;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ShipmentRepository shipmentRepo;





    @Test
    public void trueIsTrue()
    {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetAllOfEntities()
    {
        //given

        //when
        ArrayList<CustomerEntity> customers = (ArrayList<CustomerEntity>) customerRepo.findAll();
        ArrayList<CourierEntitiy> couriers = (ArrayList<CourierEntitiy>) courierRepo.findAll();
        ArrayList<OpinionEntity> opinions = (ArrayList<OpinionEntity>) opinionRepo.findAll();
        ArrayList<OutpostEntity> outposts = (ArrayList<OutpostEntity>) outpostRepo.findAll();
        ArrayList<ShipmentEntity> shipments = (ArrayList<ShipmentEntity>)shipmentRepo.findAll();
        ArrayList<ProductEntity> products = (ArrayList<ProductEntity>) productRepo.findAll();

        //then
        Assert.assertEquals(3,customers.size());
        Assert.assertEquals(3,couriers.size());
        Assert.assertEquals(8,opinions.size());
        Assert.assertEquals(6,outposts.size());
        Assert.assertEquals(6,shipments.size());
        Assert.assertEquals(21,products.size());
    }
    @Test
    public void shouldAddCustomers()
    {
        //given
        CustomerEntity customer = new CustomerEntity(null,"Alek","1234","Somewhere",null,null);;
        ArrayList<CustomerEntity> result = (ArrayList<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(3,result.size());

        //when
        customerRepo.save(customer);
         result = (ArrayList<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(4,result.size());

    }
}
