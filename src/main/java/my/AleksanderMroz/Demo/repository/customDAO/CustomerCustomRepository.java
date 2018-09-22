package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerCustomRepository {

    List<CustomerEntity> findCustomerByName(@Param("name") String name);
}
