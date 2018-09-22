package my.AleksanderMroz.Demo.repository.customDAO.implementation;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
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

}
