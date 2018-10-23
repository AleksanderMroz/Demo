package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.service.CourierService;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.service.OpinionService;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Transactional
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepo;



    @Test
    public void shouldAddAndRemoveCustomer()
    {
        List<CustomerEntity> list= (List<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(3,list.size());

        CustomerTo new_customer = new CustomerTo(null,"Andrzej","TopSecret","JanaPawlaII",null,null);
        customerService.saveCustomer(new_customer);

        list = (List<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(4,list.size());

         CustomerEntity our_customer = customerRepo.findById(4L).get();
        Assert.assertEquals("Andrzej",our_customer.getCustomerName());

        customerService.deleteCustomer(4L);
        list= (List<CustomerEntity>) customerRepo.findAll();
        Assert.assertEquals(3,list.size());
    }

//    List<CustomerTo> findCustomerByName(String name);
    @Test
    public void shouldFindCustomerByName()
    {
        List<CustomerTo> list_of_customer=customerService.findCustomerByName("Aleksander");
        Assert.assertEquals("Aleksander",list_of_customer.get(0).getCustomerName());
        Assert.assertEquals(1,list_of_customer.size());
        Assert.assertEquals("MOSCOW",list_of_customer.get(0).getAddress());
    }


//    List<OpinionTo> findCustomersOpinion(CustomerTo customerTo);
@Test
public void shouldFindCustomerOpinion()
{
    //given
    CustomerTo customerTo =customerService.findCustomerByName("Aleksander").get(0);
    //when
    List<OpinionTo> list_of_opinions =customerService.findCustomersOpinion(customerTo);
    //then
    Assert.assertEquals(5,list_of_opinions.size());

    //given
    customerTo =customerService.findCustomerByName("Bolek").get(0);
    //when
    list_of_opinions =customerService.findCustomersOpinion(customerTo);
    //then
    Assert.assertEquals(3,list_of_opinions.size());


    //given
    customerTo =customerService.findCustomerByName("Czarek").get(0);
    //when
    list_of_opinions =customerService.findCustomersOpinion(customerTo);
    //then
    Assert.assertEquals(0,list_of_opinions.size());
}

//    List<ProductTo> findCustomersProduct(CustomerTo customerTo);


    @Test
    public void shouldFindCustomerProduct()
    {

    CustomerTo customerTo =customerService.findCustomerByName("Aleksander").get(0);
    List<ProductTo> list_of_product =customerService.findCustomersProduct(customerTo);
    Assert.assertEquals(7,list_of_product.size());
    }

//    List<ShipmentTo> findAllDeliveredShipments(CustomerTo customerTo);
    @Test
    public void shouldFindAllDeliveredShipments()
    {
        //when
        CustomerTo customerTo =customerService.findCustomerByName("Aleksander").get(0);
        //when
        List<ShipmentTo> list_of_shipments = customerService.findAllDeliveredShipments(customerTo);
        //then
        Assert.assertEquals(0,list_of_shipments.size());

        //when
        customerTo =customerService.findCustomerByName("Bolek").get(0);
        //when
        list_of_shipments = customerService.findAllDeliveredShipments(customerTo);
        //then
        Assert.assertEquals(1,list_of_shipments.size());

    }


//    List<ShipmentTo> findAllShipments(CustomerTo customerTo);

    @Test
    public void shouldFindAllShipments()
    {
        //given
        CustomerTo customerTo =customerService.findCustomerByName("Aleksander").get(0);

        //when
        List<ShipmentTo> list_of_shipments = customerService.findAllShipments(customerTo);

        //then
        Assert.assertEquals(2,list_of_shipments.size());

    }



}
