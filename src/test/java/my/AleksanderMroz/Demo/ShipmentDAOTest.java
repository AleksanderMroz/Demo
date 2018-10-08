package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.OutpostRepository;
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

    @Autowired
    OutpostRepository outpostRepository;


    @Test
    public void trueIsTrue()
    {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldGetShipmentById()
    {
        //given

        //when
         Optional<ShipmentEntity> first = shipmentRepository.findById(1L);

         //then
         Assert.assertNotNull(first);
         Assert.assertEquals(1001,first.get().getValue());
         Assert.assertEquals(ShipmentStatus.TRANSPORT,first.get().getStatus());
    }

    @Test
    public void shouldGetShipmentByDestination()
    {

        //given

        //when
        List<ShipmentEntity> second = shipmentRepository.findShipmentByDestination(Cities.WROCLAW);

        //then
        Assert.assertNotNull(second);
        Assert.assertEquals(1,second.size());


    }

    @Test
    public void shouldGetShipmentByStatus()
    {
        //given

        //when
        List<ShipmentEntity> allFive= shipmentRepository.findShipmentByStatus(ShipmentStatus.TRANSPORT);

        //then
        Assert.assertNotNull(allFive);
        Assert.assertEquals(4,allFive.size());
    }

    @Test
    public void shouldFindShipmentsInOutpost()
    {
        //given
        OutpostEntity outpost = outpostRepository.findById(2L).get();

        //when
        List<ShipmentEntity> result= shipmentRepository.findShipmentsInOutpost(outpost);

        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(3,result.size());
    }




}
