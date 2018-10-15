package my.AleksanderMroz.Demo.entity;


import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.enumeration.SizeStatus;
import my.AleksanderMroz.Demo.enumeration.VariantStatus;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PRODUCT")
@Proxy(lazy=false)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int value;

    @Enumerated(EnumType.STRING)
    private SizeStatus sizeStatus;

    @Enumerated(EnumType.STRING)
    private VariantStatus variantStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_SHIPMENT")
    private ShipmentEntity whole_package;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="described_product",cascade={CascadeType.ALL})
    private List<OpinionEntity> opinions;

    public ProductEntity() {
    }

    public ProductEntity(Long id, int value, SizeStatus sizeStatus, VariantStatus variantStatus, ShipmentEntity whole_package, List<OpinionEntity> opinions) {
        this.id = id;
        this.value = value;
        this.sizeStatus = sizeStatus;
        this.variantStatus = variantStatus;
        this.whole_package = whole_package;
        this.opinions = opinions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SizeStatus getSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(SizeStatus sizeStatus) {
        this.sizeStatus = sizeStatus;
    }

    public VariantStatus getVariantStatus() {
        return variantStatus;
    }

    public void setVariantStatus(VariantStatus variantStatus) {
        this.variantStatus = variantStatus;
    }

    public ShipmentEntity getWhole_package() {
        return whole_package;
    }

    public void setWhole_package(ShipmentEntity whole_package) {
        this.whole_package = whole_package;
    }

    public List<OpinionEntity> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<OpinionEntity> opinions) {
        this.opinions = opinions;
    }
}
