package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.mapper.*;
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
        return CustomerMapper.map2To(customerRepository.findCustomerByName(name));
    }

    @Override
    public List<OpinionTo> findCustomersOpinion(CustomerTo customerTo) {
        return OpinionMapper.map2To(customerRepository.findCustomersOpinion(CustomerMapper.map(customerTo)));
    }

    @Override
    public List<ProductTo> findCustomersProduct(CustomerTo customerTo) {
        return ProductMapper.map2To(customerRepository.findCustomersProduct(CustomerMapper.map(customerTo)));
    }

    @Override
    public List<ShipmentTo> findAllDeliveredShipments(CustomerTo customerTo) {
        return ShipmentMapper.map2To(customerRepository.findAllDeliveredShipments(CustomerMapper.map(customerTo)));
    }

    @Override
    public List<ShipmentTo> findAllShipments(CustomerTo customerTo) {
        return ShipmentMapper.map2To(customerRepository.findAllShipments(CustomerMapper.map(customerTo)));
    }

    @Override
    public CustomerTo saveCustomer(CustomerTo customerTo) {
        customerRepository.save(CustomerMapper.map(customerTo));
        return customerTo;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }
}
