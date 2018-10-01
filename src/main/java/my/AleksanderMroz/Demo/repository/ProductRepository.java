package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}
