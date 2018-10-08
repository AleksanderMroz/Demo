package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;

import java.util.List;

public interface ProductCustomRepository {

    /**
     *
     * @param product - it can be anything - somethink that we can order from internet.
     * @return List of Opinions about this specified product - there can be only one unique product in DB. It's like category. It can be bought by lot's of people. Each product contains a list of opinions.
     * List of opinions can be empty or non-empty
     */
    List<OpinionEntity> getAllOpinions(ProductEntity product);

}
