package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;


import java.util.List;

public interface ShipmentCustomRepository {

    /**
     *
     * @param destination - It's a city, defined by company (thats me @author), where should be final point
     * @return a list od shipmentEntities that are ordered to specified location.
     * List can have size from 0 to infinity
     */
    List<ShipmentEntity> findShipmentByDestination( Cities destination);

    /**
     *
     * @param status - It's a shipment status - it says if shipment is delivered, on way or waiting for some reason
     * @return List o shipmentEntities that have specified status
     * List can have size from 0 to infinity
     */
    List<ShipmentEntity> findShipmentByStatus( ShipmentStatus status);

    /**
     *
     * @param outpost - base, warehouse, or another place where we can hold shipments
     * @return List of shipments, that are currentyly in this warehouse. Shipment can visit few outpost during way to owner.
     * Return list of shipment in specified outpost
     * It can be empty or non-emptylist
     */
    List<ShipmentEntity> findShipmentsInOutpost (OutpostEntity outpost);

}
