package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OutpostMapper;
import my.AleksanderMroz.Demo.mapper.ShipmentMapper;
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
        return ShipmentMapper.map2To(shipmentRepository.findShipmentByDestination(destination));
    }

    @Override
    public List<ShipmentTo> findShipmentByStatus(ShipmentStatus status) {

        return ShipmentMapper.map2To(shipmentRepository.findShipmentByStatus(status));
    }

    @Override
    public List<ShipmentTo> findShipmentsInOutpost(OutpostTo outpost) {
        return ShipmentMapper.map2To(shipmentRepository.findShipmentsInOutpost(OutpostMapper.map(outpost)));
    }

    @Override
    public ShipmentTo saveShipment(ShipmentTo shipment) {

        ShipmentEntity shipmentEntitiy = ShipmentMapper.map(shipment);
        shipmentRepository.save(shipmentEntitiy);
        return shipment;
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
