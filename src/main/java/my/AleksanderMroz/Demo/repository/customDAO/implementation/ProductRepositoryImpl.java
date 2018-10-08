package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.repository.customDAO.ProductCustomRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<OpinionEntity> getAllOpinions(ProductEntity product) {
        return null;
    }
}
