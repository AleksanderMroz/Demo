package my.AleksanderMroz.Demo.to;


import my.AleksanderMroz.Demo.entity.ShipmentEntity;

import java.util.List;

public class CourierTo {
    private Long id;
    private String courierName;
    private String password;
    private String address;
    private List<ShipmentEntity> shipments;



    public CourierTo() {
    }

    public CourierTo(Long id, String courierName, String password, String address, List<ShipmentEntity> shipments) {
        this.id = id;
        this.courierName = courierName;
        this.password = password;
        this.address = address;
        this.shipments = shipments;
    }

    public Long getId() {
        return id;
    }

    public String getCourierName() {
        return courierName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public List<ShipmentEntity> getShipments() {
        return shipments;
    }
}
