package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.to.CourierTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;

import java.util.List;

public interface CourierService {

    List<CourierTo> findAllCouriers();
    List<CourierTo> findAllCouriersThatCarriedShipment(ShipmentTo shipment);
    void changeShipmentLocation(ShipmentTo shipment);
    void changeShipmentStatus(ShipmentTo shipment);

    CourierTo saveCourier(CourierTo courier);
    void deleteCourier(Long id);

}
