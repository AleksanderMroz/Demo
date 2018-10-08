package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.repository.customDAO.CourierCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourierRepositoryImpl implements CourierCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CourierEntitiy> findAllCouriersThatCarriedShipment(ShipmentEntity shipment) {
        return null;
    }
}
