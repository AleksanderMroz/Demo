package my.AleksanderMroz.Demo.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Proxy(lazy=false)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String customerName;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 200)
    private String address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="owner", orphanRemoval = true,cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShipmentEntity> shipments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="customer_id", orphanRemoval = true,cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<OpinionEntity> opinions;


    protected CustomerEntity() {
    }

    public CustomerEntity(Long id, String customerName, String password, String address, List<ShipmentEntity> shipments, List<OpinionEntity> opinions) {
        this.id = id;
        this.customerName = customerName;
        this.password = password;
        this.address = address;
        this.shipments = shipments;
        this.opinions = opinions;
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

    public List<ShipmentEntity> getShipments() {
        return shipments;
    }

    public void setShipments(List<ShipmentEntity> shipments) {
        this.shipments = shipments;
    }

    public List<OpinionEntity> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<OpinionEntity> opinions) {
        this.opinions = opinions;
    }
}
