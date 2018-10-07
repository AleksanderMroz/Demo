package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import com.querydsl.jpa.impl.JPAQueryFactory;
import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.enumeration.Cities;
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
    public List<ShipmentEntity> findShipmentByDestination(Cities destination) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;

        List<ShipmentEntity>shipment_list= queryFactory.selectFrom(shipment).where(shipment.endOutpost.location.eq(destination)).fetch();
        return shipment_list;
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
    public List<ShipmentEntity> findShipmentsInOutpost(OutpostEntity given_outpost) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;

        List<ShipmentEntity>shipment_list= queryFactory.selectFrom(shipment).where(shipment.currentOutpost.eq(given_outpost)).fetch();
        return shipment_list;
    }


}
