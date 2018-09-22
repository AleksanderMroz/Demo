package my.AleksanderMroz.Demo.repository;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository {

    List<CustomerEntity> findCustomerByName(@Param("name") String name);


}
