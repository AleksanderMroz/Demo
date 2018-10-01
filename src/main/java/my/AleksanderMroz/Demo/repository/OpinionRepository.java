package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<OpinionEntity, Long> {
}
