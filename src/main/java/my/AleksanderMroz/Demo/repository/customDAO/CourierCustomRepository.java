package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;

import java.util.List;

public interface CourierCustomRepository {


    /**
     * @param shipment - shipment entity - the package of product which was ordered by some customer
     * @return List of Courier which were carring this shipment
     */
    List<CourierEntitiy> findAllCouriersThatCarriedShipment(ShipmentEntity shipment);

}
