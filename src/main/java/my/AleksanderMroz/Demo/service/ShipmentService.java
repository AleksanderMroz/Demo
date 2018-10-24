package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.to.OutpostTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;

import java.util.List;

public interface ShipmentService {
    List<ShipmentTo> findShipmentByDestination(Cities destination);
    List<ShipmentTo> findShipmentByStatus( ShipmentStatus status);
    List<ShipmentTo> findShipmentsInOutpost (OutpostTo outpost);

    List<ShipmentTo> findAll();
    ShipmentTo saveShipment(ShipmentTo shipment);
    void deleteShipment(Long id);
}
