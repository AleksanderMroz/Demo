package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CustomerDAOTest {

    @Autowired
    CustomerRepository customerRepo;
    @Test
    public void trueIsTrue()
    {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetCustomers()
    {
        ArrayList<CustomerEntity> result = (ArrayList<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(3,result.size());
    }

    @Test
    public void shouldGetCustomersByName()
    {
        List<CustomerEntity> result =  customerRepo.findCustomerByName("Aleksander");
        Assert.assertEquals(1,result.size());

        ArrayList<CustomerEntity> result2 = (ArrayList<CustomerEntity>) customerRepo.findCustomerByName("NameThatDontExist");
        Assert.assertEquals(0,result2.size());
    }

    @Test
    public void findCustomerOpinions()
    {
       //given
        CustomerEntity cust1 = customerRepo.findById(1L).get();
        //when
        List<OpinionEntity> opinions = customerRepo.findCustomersOpinion(cust1);

        //then
        Assert.assertEquals(5,opinions.size());
    }

    @Test
    public void findCustomerDeliveredShipments()
    {
        //given
        CustomerEntity cust2 = customerRepo.findById(2L).get();
        //when
        List<ShipmentEntity> delivered_shipments = customerRepo.findAllDeliveredShipments(cust2);

        //then
        Assert.assertEquals(1,delivered_shipments.size());
    }

    @Test
    public void findCustomerShipments()
    {
        //given
        CustomerEntity cust2 = customerRepo.findById(2L).get();
        //when
        List<ShipmentEntity> delivered_shipments = customerRepo.findAllShipments(cust2);

        //then
        Assert.assertEquals(2,delivered_shipments.size());
    }

}
