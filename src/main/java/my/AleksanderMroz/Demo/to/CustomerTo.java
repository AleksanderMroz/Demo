package my.AleksanderMroz.Demo.to;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;

import java.util.List;

public class CustomerTo {
    private Long id;
    private String customerName;
    private String password;
    private String address;
    private List<ShipmentEntity> shipments;
    private List<OpinionEntity>opinions;

    public CustomerTo()
    {
    }

    public CustomerTo(Long id, String customerName, String password, String address, List<ShipmentEntity> shipments, List<OpinionEntity> opinions) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
        this.address = address;
        this.shipments = shipments;
        this.opinions = opinions;
    }

    public List<OpinionEntity> getOpinions() {
        return opinions;
    }

    public List<ShipmentEntity> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentEntity> shipments) {
        this.shipments = shipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
