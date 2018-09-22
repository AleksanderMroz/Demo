package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentCustomRepository {

    List<ShipmentEntity> findShipmentByDestination(@Param("destination") String destination);

    List<ShipmentEntity> findShipmentById(@Param("id") long id);

    List<ShipmentEntity> findShipmentByStatus(@Param("status") ShipmentStatus status);
}
