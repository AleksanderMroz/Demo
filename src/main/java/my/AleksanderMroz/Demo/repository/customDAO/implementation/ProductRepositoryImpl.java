package my.AleksanderMroz.Demo.repository.customDAO.implementation;


import com.querydsl.jpa.impl.JPAQueryFactory;
import my.AleksanderMroz.Demo.entity.*;
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
    public List<OpinionEntity> getAllOpinions(ProductEntity productEntity) {
        Long specific_ID = productEntity.getId();
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QProductEntity product =QProductEntity.productEntity;
        QOpinionEntity opinion = QOpinionEntity.opinionEntity;


        List<OpinionEntity>opinion_list= queryFactory.selectFrom(opinion).innerJoin(product).on(product.opinions.contains(opinion)).
                where(product.id.eq(specific_ID))
                .fetch();
        return   opinion_list;
    }
}
