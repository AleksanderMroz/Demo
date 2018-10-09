package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.repository.CourierRepository;
import my.AleksanderMroz.Demo.repository.CustomerRepository;
import my.AleksanderMroz.Demo.repository.ProductRepository;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import org.hibernate.validator.internal.util.logging.Log;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;
import java.util.List;

import static java.io.Console.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CourierDAOTest {

    @Autowired
    CourierRepository courierRepository;

    @Autowired
    ShipmentRepository shipmentRepository;


    @Test
    public void getAllOpinions()
    {
        //given
        ShipmentEntity shipment = shipmentRepository.findById(1L).get();
        //when
        List<CourierEntitiy> list_couriers= courierRepository.findAllCouriersThatCarriedShipment(shipment);

        //then
        int x=2;
        x=x+2;
        Assert.assertEquals(2,list_couriers.size());
    }


}
