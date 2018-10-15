package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
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



@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CourierServiceTest {


    @Autowired
    CourierService courierService;

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
    public void shouldChangeLocationOfShipment()
    {

        ShipmentTo shipmentTo= ShipmentMapper.map(shipmentRepo.findById(1L).get());
        OutpostTo outpostTo = OutpostMapper.map(outpostRepo.findById(1L).get());
        courierService.changeShipmentLocation(shipmentTo,outpostTo);

        ShipmentEntity shipmentEntity = shipmentRepo.findById(1L).get();
        OutpostEntity getOutpost = shipmentEntity.getCurrentOutpost();
        Cities status = getOutpost.getLocation();
        Assert.assertEquals(1001L,shipmentEntity.getValue());


    }




}
