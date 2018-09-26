package my.AleksanderMroz.Demo.entity;

import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;

import javax.persistence.*;

@Entity
@Table(name="SHIPMENT")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String destination;
    @Column(nullable = false, length = 200)
    private long value;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "ID_OWNER")
    CustomerEntity owner;

    protected ShipmentEntity() {
    }

    public ShipmentEntity(Long id, String destination, long value, ShipmentStatus status) {
        this.id = id;
        this.destination = destination;
        this.value = value;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }
}
