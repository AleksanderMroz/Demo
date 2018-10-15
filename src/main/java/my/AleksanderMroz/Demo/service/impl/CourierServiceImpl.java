package my.AleksanderMroz.Demo.service.impl;



import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OutpostMapper;
import my.AleksanderMroz.Demo.mapper.ShipmentMapper;
import my.AleksanderMroz.Demo.repository.CourierRepository;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import my.AleksanderMroz.Demo.service.CourierService;
import my.AleksanderMroz.Demo.to.CourierTo;
import my.AleksanderMroz.Demo.to.OutpostTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {
    private CourierRepository courierRepository;
    private ShipmentRepository shipmentRepository;
    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository,ShipmentRepository shipmentRepository){
        this.courierRepository=courierRepository;
        this.shipmentRepository=shipmentRepository;
    }


    @Override
    public List<CourierTo> findAllCouriers() {
        return CourierMapper.map2To((List<CourierEntitiy>) courierRepository.findAll());
    }

    @Override
    public List<CourierTo> findAllCouriersThatCarriedShipment(ShipmentTo shipment) {

        return CourierMapper.map2To(courierRepository.findAllCouriersThatCarriedShipment(ShipmentMapper.map(shipment)));
    }

    @Override
    public void changeShipmentLocation(ShipmentTo shipment, OutpostTo outpost) {
        Long id = shipment.getId();
        ShipmentEntity toChange= shipmentRepository.findById(id).get();
        toChange.setCurrentOutpost(OutpostMapper.map(outpost));
        shipmentRepository.save(toChange);
    }

    @Override
    public void changeShipmentStatus(ShipmentTo shipment, ShipmentStatus status) {

        Long id = shipment.getId();
        ShipmentEntity toChange= shipmentRepository.findById(id).get();
        toChange.setStatus(status);
        shipmentRepository.save(toChange);
    }

    @Override
    public CourierTo saveCourier(CourierTo courier) {

        CourierEntitiy courierEntitiy = CourierMapper.map(courier);
        courierRepository.save(courierEntitiy);
        return CourierMapper.map(courierEntitiy);
    }

    @Override
    public void deleteCourier(Long id) {

    courierRepository.deleteById(id);

    }
}
