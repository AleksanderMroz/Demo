package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import my.AleksanderMroz.Demo.repository.customDAO.ShipmentCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipmentRepositoryImpl implements ShipmentCustomRepository {
    @Override
    public List<ShipmentEntity> findShipmentByDestination(String destination) {
        return null;
    }

    @Override
    public List<ShipmentEntity> findShipmentById(long id) {
        return null;
    }

    @Override
    public List<ShipmentEntity> findShipmentByStatus(ShipmentStatus status) {
        return null;
    }
}
