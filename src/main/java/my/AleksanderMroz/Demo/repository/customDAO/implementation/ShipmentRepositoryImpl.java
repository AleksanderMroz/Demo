package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.ShipmentRepository;
import my.AleksanderMroz.Demo.repository.customDAO.ShipmentCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ShipmentRepositoryImpl implements ShipmentCustomRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<ShipmentEntity> findShipmentByDestination(String destination) {
        TypedQuery<ShipmentEntity> query = entityManager.createQuery(
                "select shipment from ShipmentEntity shipment where upper(shipment.destination) like concat(upper(:destination), '%')",
                ShipmentEntity.class);
            query.setParameter("destination", destination);

        return query.getResultList();
    }
    @Override
    public List<ShipmentEntity> findShipmentByStatus(ShipmentStatus status) {
        String statusString = status.toString();
        TypedQuery<ShipmentEntity> query = entityManager.createQuery(
                "select shipment from ShipmentEntity shipment where upper(shipment.status) like concat(upper(:status), '%')",
                ShipmentEntity.class);
        query.setParameter("status", statusString);

        return query.getResultList();
    }

    @Override
    public List<ShipmentEntity> findShipmentsInOutpost(OutpostEntity outpost) {
        return null;
    }


}
