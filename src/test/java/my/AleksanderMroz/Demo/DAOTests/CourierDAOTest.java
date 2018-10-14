package my.AleksanderMroz.Demo.DAOTests;


import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.repository.*;
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

    @Autowired
    OutpostRepository outpostRepository;


    @Test
    public void getAllOpinions()
    {
        //given
        ShipmentEntity shipment = shipmentRepository.findById(1L).get();
        //when
        List<CourierEntitiy> list_couriers= courierRepository.findAllCouriersThatCarriedShipment(shipment);

        //then
        Assert.assertEquals(2,list_couriers.size());
    }

    @Test
    public void changeShipmentLocation()
    {
        //given
        ShipmentEntity shipment = shipmentRepository.findById(1L).get();
        OutpostEntity outpost = outpostRepository.findById(2L).get();
        OutpostEntity new_outpost = outpostRepository.findById(3L).get();


        OutpostEntity gotOutpost=shipment.getCurrentOutpost();
        long gotId= gotOutpost.getId();
        Assert.assertEquals(1001,shipment.getValue());
        Assert.assertEquals(2L,gotId);

        List<ShipmentEntity> shipments_list = (List<ShipmentEntity>) shipmentRepository.findAll();
        Assert.assertEquals(6, shipments_list.size());


        //when

        shipment.setCurrentOutpost(new_outpost);
        shipmentRepository.save(shipment);
        //then
        shipment = shipmentRepository.findById(1L).get();
        OutpostEntity gotOutpost2=shipment.getCurrentOutpost();
        long gotId2= gotOutpost2.getId();

        Assert.assertEquals(1001,shipment.getValue());
        Assert.assertEquals(3L,gotId2);

        shipments_list = (List<ShipmentEntity>) shipmentRepository.findAll();
        Assert.assertEquals(6, shipments_list.size());
    }




}
