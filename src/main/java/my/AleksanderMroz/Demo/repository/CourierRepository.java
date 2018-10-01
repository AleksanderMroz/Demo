package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import org.springframework.data.repository.CrudRepository;




public interface CourierRepository extends CrudRepository<CourierEntitiy, Long> {
}