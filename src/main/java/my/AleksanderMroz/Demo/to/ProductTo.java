package my.AleksanderMroz.Demo.to;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ShipmentEntity;
import my.AleksanderMroz.Demo.enumeration.SizeStatus;
import my.AleksanderMroz.Demo.enumeration.VariantStatus;

import java.util.List;

public class ProductTo{

    private Long id;
    private int value;
    private SizeStatus sizeStatus;
    private VariantStatus variantStatus;
    private ShipmentEntity whole_package;
    private List<OpinionEntity> opinions;

    public ProductTo() {
    }

    public ProductTo(Long id, int value, SizeStatus sizeStatus, VariantStatus variantStatus, ShipmentEntity whole_package, List<OpinionEntity> opinions) {
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

    public int getValue() {
        return value;
    }

    public SizeStatus getSizeStatus() {
        return sizeStatus;
    }

    public VariantStatus getVariantStatus() {
        return variantStatus;
    }

    public ShipmentEntity getWhole_package() {
        return whole_package;
    }

    public List<OpinionEntity> getOpinions() {
        return opinions;
    }
}
