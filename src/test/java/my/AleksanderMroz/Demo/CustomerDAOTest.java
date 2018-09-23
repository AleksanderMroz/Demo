package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
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
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void shouldGetCustomersByName()
    {
        List<CustomerEntity> result =  customerRepo.findCustomerByName("Aleksander");
        Assert.assertEquals(1,result.size());

        ArrayList<CustomerEntity> result2 = (ArrayList<CustomerEntity>) customerRepo.findCustomerByName("NameThatDontExist");
        Assert.assertEquals(0,result2.size());
    }

}
