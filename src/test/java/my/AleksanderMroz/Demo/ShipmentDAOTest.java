package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Transactional
public class ShipmentDAOTest {
    @Autowired
    ShipmentRepository shipmentRepository;


    @Test
    public void trueIsTrue()
    {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetShipment()
    {

         Optional<ShipmentEntity> first = shipmentRepository.findById(1L);
         Assert.assertNotNull(first);
         Assert.assertEquals("Moscow",first.get().getDestination());
        Assert.assertEquals(1500,first.get().getValue());
        Assert.assertEquals(ShipmentStatus.WAIT,first.get().getStatus());

    }

}
