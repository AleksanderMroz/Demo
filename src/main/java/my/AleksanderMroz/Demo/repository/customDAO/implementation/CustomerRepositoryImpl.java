package my.AleksanderMroz.Demo.repository.customDAO.implementation;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import my.AleksanderMroz.Demo.entity.*;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.CustomerRepository;
import my.AleksanderMroz.Demo.repository.customDAO.CustomerCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CustomerEntity> findCustomerByName(String name) {
        TypedQuery<CustomerEntity> query = entityManager.createQuery(
                "select customer from CustomerEntity customer where upper(customer.customerName) like concat(upper(:name), '%')",
                CustomerEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<OpinionEntity> findCustomersOpinion(CustomerEntity customerEntity) {
        Long specific_ID = customerEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCustomerEntity customer= QCustomerEntity.customerEntity;
        QOpinionEntity opinion = QOpinionEntity.opinionEntity;


        List<OpinionEntity>opinion_list= queryFactory.selectFrom(opinion).innerJoin(customer).on(customer.opinions.contains(opinion)).
                where(customer.id.eq(specific_ID))
        .fetch();
        return   opinion_list;
    }

    @Override
    public List<ProductEntity> findCustomersProduct(CustomerEntity customerEntity) {
        Long specific_ID = customerEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCustomerEntity customer= QCustomerEntity.customerEntity;
        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;
        QProductEntity product = QProductEntity.productEntity;

        List<ProductEntity>product_list= queryFactory.selectFrom(product).innerJoin(shipment).on(customer.shipments.contains(shipment)).innerJoin(product).on(shipment.products.contains(product)).fetch();
        return   product_list;
    }

    @Override
    public List<ShipmentEntity> findAllDeliveredShipments(CustomerEntity customerEntity) {
        Long specific_ID = customerEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCustomerEntity customer= QCustomerEntity.customerEntity;
        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;
        ShipmentStatus status = ShipmentStatus.DELIVERED;


        List<ShipmentEntity>shipment_list= queryFactory.selectFrom(shipment).innerJoin(customer).on(customer.shipments.contains(shipment)).
                where(customer.id.eq(specific_ID).and(shipment.status.eq(status)))
                .fetch();
        return   shipment_list;
    }

    @Override
    public List<ShipmentEntity> findAllShipments(CustomerEntity customerEntity) {


        Long specific_ID = customerEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCustomerEntity customer= QCustomerEntity.customerEntity;
        QShipmentEntity shipment = QShipmentEntity.shipmentEntity;
        ShipmentStatus status = ShipmentStatus.DELIVERED;


        List<ShipmentEntity>shipment_list= queryFactory.selectFrom(shipment).innerJoin(customer).on(customer.shipments.contains(shipment)).
                where(customer.id.eq(specific_ID))
                .fetch();
        return   shipment_list;
    }

}
