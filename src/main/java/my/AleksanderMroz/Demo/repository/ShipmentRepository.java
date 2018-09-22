package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.repository.customDAO.ShipmentCustomRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipmentRepository extends CrudRepository<ShipmentEntity, Long> , ShipmentCustomRepository {




}
