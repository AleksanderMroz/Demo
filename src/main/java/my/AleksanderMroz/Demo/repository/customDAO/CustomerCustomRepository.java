package my.AleksanderMroz.Demo.repository.customDAO;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerCustomRepository {

    /**
     *
     * @param name - given name
     * @return List of Customers that have this specified name
     */
    List<CustomerEntity> findCustomerByName( String name);

    /**
     *
     * @param customerEntity - customer with all data, which he has
     * @return List of Opinions, which our customer had ever wrote
     */
    List<OpinionEntity> findCustomersOpinion(CustomerEntity customerEntity);

    /**
     *
     * @param customerEntity - customer with all data, which he has
     * @return List of Product, which our customer had ever bought.
     * If he bought one product two times, it will count as 1
     */
    List<ProductEntity> findCustomersProduct(CustomerEntity customerEntity);

    /**
     *
     * @param customerEntity - customer with all data, which he has
     * @return List of Shipments, which our customer had ever got.
     */
    List<ShipmentEntity> findAllDeliveredShipments(CustomerEntity customerEntity);

    /**
     * @param customerEntity - customer with all data, which he has
     * @return List of Shipments, which our customer had ever got or are on their way to customer
     */
    List<ShipmentEntity> findAllShipments(CustomerEntity customerEntity);
}
