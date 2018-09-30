package my.AleksanderMroz.Demo.entity;


import my.AleksanderMroz.Demo.enumeration.ShipmentStatus;
import my.AleksanderMroz.Demo.enumeration.SizeStatus;
import my.AleksanderMroz.Demo.enumeration.VariantStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PRODUCT")
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

    public ProductEntity(Long id, int value, SizeStatus sizeStatus, VariantStatus variantStatus) {
        this.id = id;
        this.value = value;
        this.sizeStatus = sizeStatus;
        this.variantStatus = variantStatus;
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
}
