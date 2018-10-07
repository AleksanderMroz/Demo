package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;


import java.util.List;

public interface ShipmentCustomRepository {

    List<ShipmentEntity> findShipmentByDestination( Cities destination);
    List<ShipmentEntity> findShipmentByStatus( ShipmentStatus status);
    List<ShipmentEntity> findShipmentsInOutpost (OutpostEntity outpost);

}
