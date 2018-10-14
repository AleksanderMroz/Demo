package my.AleksanderMroz.Demo.DAOTests;


import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.mapper.*;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.to.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Transactional
public class MapperTests {

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

    CustomerMapper customerMapper;
    ShipmentMapper shipmentMapper;
    CourierMapper courierMapper;
    OpinionMapper opinionMapper;
    ProductMapper productMapper;
    OutpostMapper outpostMapper;

    @Test
    public void shouldMapCustomers()
    {
        //given
        CustomerEntity customerEntity=customerRepo.findById(1L).get();
        List<CustomerEntity>list_Entities = (List<CustomerEntity>) customerRepo.findAll();

        //when
        CustomerTo customerTo= customerMapper.map(customerEntity);
        List<CustomerTo> list_Tos = customerMapper.map2To(list_Entities);

        List<CustomerEntity>list_Entities2 = customerMapper.map2Entity(list_Tos);



        //then
        Assert.assertEquals(customerEntity.getCustomerName(),customerTo.getCustomerName());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getCustomerName(),list_Tos.get(0).getCustomerName());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getCustomerName(),list_Entities2.get(0).getCustomerName());
    }
    @Test
    public void shouldMapShipments()
    {
        //given
        ShipmentEntity shipmentEntity=shipmentRepo.findById(1L).get();
        List<ShipmentEntity>list_Entities = (List<ShipmentEntity>) shipmentRepo.findAll();

        //when
        ShipmentTo shipmentTo= shipmentMapper.map(shipmentEntity);
        List<ShipmentTo> list_Tos = shipmentMapper.map2To(list_Entities);

        List<ShipmentEntity>list_Entities2 = shipmentMapper.map2Entity(list_Tos);



        //then
        Assert.assertEquals(shipmentEntity.getValue(),shipmentTo.getValue());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getValue(),list_Tos.get(0).getValue());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getValue(),list_Entities2.get(0).getValue());
    }
    @Test
    public void shouldMapCourier()
    {
        //given
        CourierEntitiy courierEntity=courierRepo.findById(1L).get();
        List<CourierEntitiy>list_Entities = (List<CourierEntitiy>) courierRepo.findAll();

        //when
        CourierTo courierTo= courierMapper.map(courierEntity);
        List<CourierTo> list_Tos = courierMapper.map2To(list_Entities);

        List<CourierEntitiy>list_Entities2 = courierMapper.map2Entity(list_Tos);


        //then
        Assert.assertEquals(courierEntity.getAddress(),courierTo.getAddress());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getAddress(),list_Tos.get(0).getAddress());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getAddress(),list_Entities2.get(0).getAddress());
    }
    @Test
    public void shouldMapOpinion()
    {
        //given
        OpinionEntity opinionEntity=opinionRepo.findById(1L).get();
        List<OpinionEntity>list_Entities = (List<OpinionEntity>) opinionRepo.findAll();

        //when
        OpinionTo opinionTo= opinionMapper.map(opinionEntity);
        List<OpinionTo> list_Tos = opinionMapper.map2To(list_Entities);

        List<OpinionEntity>list_Entities2 = opinionMapper.map2Entity(list_Tos);

        //then
        Assert.assertEquals(opinionEntity.getDescription(),opinionTo.getDescription());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getDescription(),list_Tos.get(0).getDescription());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getDescription(),list_Entities2.get(0).getDescription());
    }
    @Test
    public void shouldMapOutpost()
    {
        //given
        OutpostEntity outpostEntity=outpostRepo.findById(1L).get();
        List<OutpostEntity>list_Entities = (List<OutpostEntity>) outpostRepo.findAll();

        //when
        OutpostTo outpostTo= outpostMapper.map(outpostEntity);
        List<OutpostTo> list_Tos = outpostMapper.map2To(list_Entities);

        List<OutpostEntity>list_Entities2 = outpostMapper.map2Entity(list_Tos);

        //then
        Assert.assertEquals(outpostEntity.getLocation(),outpostTo.getLocation());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getLocation(),list_Tos.get(0).getLocation());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getLocation(),list_Entities2.get(0).getLocation());
    }
    @Test
    public void shouldMapProduct()
    {
        //given
        ProductEntity productEntity=productRepo.findById(1L).get();
        List<ProductEntity>list_Entities = (List<ProductEntity>) productRepo.findAll();

        //when
        ProductTo productTo= productMapper.map(productEntity);
        List<ProductTo> list_Tos = productMapper.map2To(list_Entities);

        List<ProductEntity>list_Entities2 = productMapper.map2Entity(list_Tos);

        //then
        Assert.assertEquals(productEntity.getValue(),productTo.getValue());
        Assert.assertEquals(list_Entities.size(),list_Tos.size());
        Assert.assertEquals(list_Entities.get(0).getValue(),list_Tos.get(0).getValue());

        Assert.assertEquals(list_Entities.size(),list_Entities2.size());
        Assert.assertEquals(list_Entities.get(0).getValue(),list_Entities2.get(0).getValue());

    }
}
