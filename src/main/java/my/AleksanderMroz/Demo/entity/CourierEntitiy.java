package my.AleksanderMroz.Demo.entity;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "COURIER")
@Proxy(lazy=false)
public class CourierEntitiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String courierName;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 200)
    private String address;



    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "couriers",cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    List<ShipmentEntity> shipments;


    public CourierEntitiy() {
    }

    public CourierEntitiy(Long id, String customerName, String password, String address, List<ShipmentEntity> shipments) {
        this.id = id;
        this.courierName = customerName;
        this.password = password;
        this.address = address;
        this.shipments = shipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String customerName) {
        this.courierName = customerName;
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

    public List<ShipmentEntity> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentEntity> shipments) {
        this.shipments = shipments;
    }
}
