package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.enumeration.SizeStatus;
import my.AleksanderMroz.Demo.enumeration.VariantStatus;
import my.AleksanderMroz.Demo.mapper.OutpostMapper;
import my.AleksanderMroz.Demo.repository.OutpostRepository;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import my.AleksanderMroz.Demo.service.OutpostService;
import my.AleksanderMroz.Demo.service.ShipmentService;
import my.AleksanderMroz.Demo.to.OutpostTo;
import my.AleksanderMroz.Demo.to.ProductTo;
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
public class ShipmentServiceTest{

    @Autowired
    ShipmentService shipmentService;
    @Autowired
    ShipmentRepository shipmentRepository;
    @Autowired
    OutpostRepository outpostRepository;



    @Test
    public void shouldAddAndRemove()
    {
       //given
        List<ShipmentEntity> list = (List<ShipmentEntity>) shipmentRepository.findAll();
        Assert.assertEquals(6,list.size());
        ShipmentTo shipmentTo = new ShipmentTo(null,1000, ShipmentStatus.TRANSPORT,null,null,null,null,null,null);

        //when
        shipmentService.saveShipment(shipmentTo);

        //then
        list = (List<ShipmentEntity>) shipmentRepository.findAll();
        Assert.assertEquals(7,list.size());

        //when
        shipmentService.deleteShipment(7L);

        //then
        list=(List<ShipmentEntity>) shipmentRepository.findAll();
        Assert.assertEquals(6,list.size());
    }

    //List<ShipmentTo> findShipmentByDestination(Cities destination);
    @Test
    public void shouldFindShipmentByDestination()
    {
        // given, when
        List<ShipmentTo> list_od_shipments = shipmentService.findShipmentByDestination(Cities.MOSCOW);

        //then
        Assert.assertEquals(2,list_od_shipments.size());
    }


    //    List<ShipmentTo> findShipmentByStatus( ShipmentStatus status);
    @Test
    public void shouldFindShipmentByStatus()
    {
        // given, when
        List<ShipmentTo> list_od_shipments = shipmentService.findShipmentByStatus(ShipmentStatus.DELIVERED);

        //then
        Assert.assertEquals(1,list_od_shipments.size());

        // given, when
        list_od_shipments = shipmentService.findShipmentByStatus(ShipmentStatus.TRANSPORT);

        //then
        Assert.assertEquals(4,list_od_shipments.size());
    }
    //    List<ShipmentTo> findShipmentsInOutpost (OutpostTo outpost);

    @Test
    public void shouldFindShipmentsInOutpost()
    {
        //given
        OutpostTo outpostTo = OutpostMapper.map(outpostRepository.findById(2L).get());
        //when
        List<ShipmentTo> list_od_shipments = shipmentService.findShipmentsInOutpost(outpostTo);
        //then
        Assert.assertEquals(3,list_od_shipments.size());



    }


}
