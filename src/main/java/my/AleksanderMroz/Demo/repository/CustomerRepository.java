package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.repository.customDAO.CustomerCustomRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>, CustomerCustomRepository {

}
