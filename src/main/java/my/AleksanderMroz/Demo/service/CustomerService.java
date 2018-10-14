package my.AleksanderMroz.Demo.service;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;

import java.util.List;

public interface CustomerService {


    List<CustomerTo> findCustomerByName(String name);
    List<OpinionTo> findCustomersOpinion(CustomerTo customerTo);
    List<ProductTo> findCustomersProduct(CustomerTo customerTo);
    List<ShipmentTo> findAllDeliveredShipments(CustomerTo customerTo);
    List<ShipmentTo> findAllShipments(CustomerTo customerTo);


    CustomerTo saveCustomer(CustomerTo customer);
    void deleteCustomer(Long id);
}
