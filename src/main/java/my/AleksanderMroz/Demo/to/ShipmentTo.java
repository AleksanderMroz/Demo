package my.AleksanderMroz.Demo.to;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;


import javax.persistence.*;
import java.util.List;

public class ShipmentTo {
    private Long id;
    private long value;
    private ShipmentStatus status;
    private OutpostEntity startOutpost;
    private OutpostEntity currentOutpost;
    private OutpostEntity endOutpost;
    private CustomerEntity owner;
    private List<ProductEntity> products;
    List<CourierEntitiy> couriers;


    public ShipmentTo() {
    }

    public ShipmentTo(Long id, long value, ShipmentStatus status, OutpostEntity startOutpost, OutpostEntity currentOutpost, OutpostEntity endOutpost, CustomerEntity owner, List<ProductEntity> products, List<CourierEntitiy> couriers) {
        this.id = id;
        this.value = value;
        this.status = status;
        this.startOutpost = startOutpost;
        this.currentOutpost = currentOutpost;
        this.endOutpost = endOutpost;
        this.owner = owner;
        this.products = products;
        this.couriers = couriers;
    }

    public Long getId() {
        return id;
    }

    public long getValue() {
        return value;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public OutpostEntity getStartOutpost() {
        return startOutpost;
    }

    public OutpostEntity getCurrentOutpost() {
        return currentOutpost;
    }

    public OutpostEntity getEndOutpost() {
        return endOutpost;
    }

    public CustomerEntity getOwner() {
        return owner;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public List<CourierEntitiy> getCouriers() {
        return couriers;
    }
}
