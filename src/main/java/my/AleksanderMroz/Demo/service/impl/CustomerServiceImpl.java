package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.repository.CustomerRepository;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;
import my.AleksanderMroz.Demo.to.ShipmentTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public List<CustomerTo> findCustomerByName(String name) {
        return null;
    }

    @Override
    public List<OpinionTo> findCustomersOpinion(CustomerTo customerTo) {
        return null;
    }

    @Override
    public List<ProductTo> findCustomersProduct(CustomerTo customerTo) {
        return null;
    }

    @Override
    public List<ShipmentTo> findAllDeliveredShipments(CustomerTo customerTo) {
        return null;
    }

    @Override
    public List<ShipmentTo> findAllShipments(CustomerTo customerTo) {
        return null;
    }

    @Override
    public CustomerTo saveCustomer(CustomerTo customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
