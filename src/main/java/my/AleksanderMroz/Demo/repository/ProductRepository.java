package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.repository.customDAO.ProductCustomRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Long>, ProductCustomRepository {
}
