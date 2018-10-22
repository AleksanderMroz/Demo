package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OutpostMapper;
import my.AleksanderMroz.Demo.mapper.ShipmentMapper;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.service.CourierService;
import my.AleksanderMroz.Demo.to.OutpostTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CourierServiceTest {


    @Autowired
    CourierService courierService;
    @Autowired
    OutpostRepository outpostRepo;
    @Autowired
    ShipmentRepository shipmentRepo;
    @Autowired
    CourierRepository courierRepo;


    @Test
    public void shouldChangeLocationOfShipment()
    {

        ShipmentTo shipmentTo= ShipmentMapper.map(shipmentRepo.findById(1L).get());
        OutpostTo outpostTo = OutpostMapper.map(outpostRepo.findById(1L).get());

        ShipmentEntity shipmentEntity = shipmentRepo.findById(1L).get();
        OutpostEntity getOutpostFirst = shipmentEntity.getCurrentOutpost();
        Cities status = getOutpostFirst.getLocation();
        Assert.assertEquals(Cities.MOSCOW,status);
        Assert.assertEquals(1001L,shipmentEntity.getValue());


        courierService.changeShipmentLocation(shipmentTo,outpostTo);

        shipmentEntity = shipmentRepo.findById(1L).get();
        OutpostEntity getOutpost = shipmentEntity.getCurrentOutpost();
        status = getOutpost.getLocation();
        Assert.assertEquals(Cities.WROCLAW,status);
        Assert.assertEquals(1001L,shipmentEntity.getValue());
    }

    @Test
    public void shouldSaveCourier()
    {
        List<CourierEntitiy>list= (List<CourierEntitiy>) courierRepo.findAll();
        Assert.assertEquals(3,list.size());

        CourierEntitiy new_courier = new CourierEntitiy(null,"Romek","1234","Some",null);
        courierService.saveCourier(CourierMapper.map(new_courier));

        list= (List<CourierEntitiy>) courierRepo.findAll();
        Assert.assertEquals(4,list.size());

        CourierEntitiy our_courier = courierRepo.findById(4L).get();
        Assert.assertEquals("Romek",our_courier.getCourierName());

        courierService.deleteCourier(4L);
        list= (List<CourierEntitiy>) courierRepo.findAll();
        Assert.assertEquals(3,list.size());
    }




}
