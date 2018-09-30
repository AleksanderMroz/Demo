package my.AleksanderMroz.Demo.entity;

import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SHIPMENT")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private long value;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="START_OUTPOST")
   private OutpostEntity startOutpost;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CURRENT_OUTPOST")
   private OutpostEntity currentOutpost;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="END_OUTPOST")
    private OutpostEntity endOutpost;


    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_OWNER")
    private CustomerEntity owner;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.MERGE })
    @JoinTable(name = "COURIER_SHIPMENT", joinColumns = {
            @JoinColumn(name = "COURIER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "SHIPMENT_ID", nullable = false, updatable = false) })
    List<CourierEntitiy> couriers;

    
    protected ShipmentEntity() {
    }

    public ShipmentEntity(Long id, String destination, long value, ShipmentStatus status, CustomerEntity owner) {
        this.id = id;
        this.value = value;
        this.status = status;
        this.owner = owner;
    }

    public CustomerEntity getOwner() {
        return owner;
    }

    public void setOwner(CustomerEntity owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
