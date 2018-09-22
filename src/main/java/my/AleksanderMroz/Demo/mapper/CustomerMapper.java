package my.AleksanderMroz.Demo.mapper;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.to.CustomerTo;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {


    public static CustomerTo map(CustomerEntity customerEntity)
    {
        if (customerEntity != null) {
            return new CustomerTo(customerEntity.getId(), customerEntity.getCustomerName(), customerEntity.getPassword(),customerEntity.getAddress());
        }
        return null;
    }

    public static CustomerEntity map(CustomerTo customerTo)
    {
        if (customerTo != null) {
            return new CustomerEntity(customerTo.getId(), customerTo.getCustomerName(), customerTo.getPassword(),customerTo.getAddress());
        }
        return null;
    }

    public static List<CustomerTo> map2To(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(CustomerMapper::map).collect(Collectors.toList());
    }

    public static List<CustomerEntity> map2Entity(List<CustomerTo> customerTos) {
        return customerTos.stream().map(CustomerMapper::map).collect(Collectors.toList());
    }



}
