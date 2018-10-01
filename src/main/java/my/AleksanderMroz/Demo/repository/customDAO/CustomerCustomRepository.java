package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerCustomRepository {

    List<CustomerEntity> findCustomerByName( String name);
    List<OpinionEntity> findCustomersOpinion(CustomerEntity customerEntity);
    List<ProductEntity> findCustomersProduct(CustomerEntity customerEntity);
    List<ShipmentEntity> findAllDeliveredShipments(CustomerEntity customerEntity);
    List<ShipmentEntity> findAllShipments(CustomerEntity customerEntity);
}
