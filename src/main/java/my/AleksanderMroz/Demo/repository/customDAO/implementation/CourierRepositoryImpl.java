package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import com.querydsl.jpa.impl.JPAQueryFactory;
import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.enumeration.Cities;
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
    public List<CourierEntitiy> findAllCouriersThatCarriedShipment(ShipmentEntity shipmentEntity) {
        Long specific_ID = shipmentEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;
        QCourierEntitiy courier = QCourierEntitiy.courierEntitiy;



        List<CourierEntitiy>courier_list= queryFactory.select(courier).from(courier).innerJoin(courier.shipments,shipment).where(courier.shipments.contains(shipmentEntity).and(shipment.id.eq(specific_ID ))).fetch();
        return   courier_list;
    }



}
