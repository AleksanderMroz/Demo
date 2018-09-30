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


    @OneToMany(fetch = FetchType.LAZY,mappedBy="whole_package",cascade={CascadeType.ALL})
    private List<ProductEntity> products;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.MERGE })
    @JoinTable(name = "COURIER_SHIPMENT", joinColumns = {
            @JoinColumn(name = "COURIER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "SHIPMENT_ID", nullable = false, updatable = false) })
    List<CourierEntitiy> couriers;




    protected ShipmentEntity() {
    }

    public ShipmentEntity(Long id, long value, ShipmentStatus status, OutpostEntity startOutpost, OutpostEntity currentOutpost, OutpostEntity endOutpost, CustomerEntity owner, List<ProductEntity> produkts, List<CourierEntitiy> couriers) {
        this.id = id;
        this.value = value;
        this.status = status;
        this.startOutpost = startOutpost;
        this.currentOutpost = currentOutpost;
        this.endOutpost = endOutpost;
        this.owner = owner;
        this.products = produkts;
        this.couriers = couriers;
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

    public OutpostEntity getStartOutpost() {
        return startOutpost;
    }

    public void setStartOutpost(OutpostEntity startOutpost) {
        this.startOutpost = startOutpost;
    }

    public OutpostEntity getCurrentOutpost() {
        return currentOutpost;
    }

    public void setCurrentOutpost(OutpostEntity currentOutpost) {
        this.currentOutpost = currentOutpost;
    }

    public OutpostEntity getEndOutpost() {
        return endOutpost;
    }

    public void setEndOutpost(OutpostEntity endOutpost) {
        this.endOutpost = endOutpost;
    }

    public CustomerEntity getOwner() {
        return owner;
    }

    public void setOwner(CustomerEntity owner) {
        this.owner = owner;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> produkts) {
        this.products = produkts;
    }

    public List<CourierEntitiy> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<CourierEntitiy> couriers) {
        this.couriers = couriers;
    }
}


