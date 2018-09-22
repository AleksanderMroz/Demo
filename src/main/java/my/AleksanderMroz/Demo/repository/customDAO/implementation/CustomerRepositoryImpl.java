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
                "select car from CarEntity car where upper(car.carType) like concat(upper(:carType), '%')",
                CustomerEntity.class);
        query.setParameter("carType", name); // cale porownanie
        return query.getResultList();
    }

    //@Query("select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')")
}
