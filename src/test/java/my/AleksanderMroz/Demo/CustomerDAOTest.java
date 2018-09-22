package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CustomerDAOTest {

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

}
