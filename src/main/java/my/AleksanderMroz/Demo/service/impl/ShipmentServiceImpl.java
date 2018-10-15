package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import my.AleksanderMroz.Demo.service.ShipmentService;
import my.AleksanderMroz.Demo.to.OutpostTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository)
    {
        this.shipmentRepository=shipmentRepository;
    }

    @Override
    public List<ShipmentTo> findShipmentByDestination(Cities destination) {
        return null;
    }

    @Override
    public List<ShipmentTo> findShipmentByStatus(ShipmentStatus status) {
        return null;
    }

    @Override
    public List<ShipmentTo> findShipmentsInOutpost(OutpostTo outpost) {
        return null;
    }

    @Override
    public ShipmentTo saveShipment(ShipmentTo shipment) {
        return null;
    }

    @Override
    public void deleteShipment(Long id) {

    }
}
