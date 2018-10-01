package my.AleksanderMroz.Demo.repository.customDAO.implementation;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import my.AleksanderMroz.Demo.entity.*;
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
        Long id = customerEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QCustomerEntity customer= QCustomerEntity.customerEntity;
        QOpinionEntity opinion = QOpinionEntity.opinionEntity;

        return (List<OpinionEntity>) queryFactory.from(customer)
                .innerJoin(customer.opinions,opinion)
                .where(customer.id.eq(opinion.customer_id.id))
                .fetch();
    }

    @Override
    public List<ProductEntity> findCustomersProduct(CustomerEntity customerEntity) {
        return null;
    }

    @Override
    public List<ShipmentEntity> findAllDeliveredShipments(CustomerEntity customerEntity) {
        return null;
    }

    @Override
    public List<ShipmentEntity> findAllShipments(CustomerEntity customerEntity) {
        return null;
    }

}
