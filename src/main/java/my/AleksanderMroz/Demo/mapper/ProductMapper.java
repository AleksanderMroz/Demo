package my.AleksanderMroz.Demo.mapper;

import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductTo map(ProductEntity productEntity)
    {
        if (productEntity != null) {
            return new ProductTo(productEntity.getId(),productEntity.getValue(),productEntity.getSizeStatus(),productEntity.getVariantStatus(),productEntity.getWhole_package(),productEntity.getOpinions());
        }
        return null;
    }

    public static ProductEntity map(ProductTo productTo)
    {
        if (productTo != null) {
            return new ProductEntity(productTo.getId(),productTo.getValue(),productTo.getSizeStatus(),productTo.getVariantStatus(),productTo.getWhole_package(),productTo.getOpinions());
        }
        return null;
    }

    public static List<ProductTo> map2To(List<ProductEntity> productEntities) {
        return productEntities.stream().map(ProductMapper::map).collect(Collectors.toList());
    }

    public static List<ProductEntity> map2Entity(List<ProductTo> productTos) {
        return productTos.stream().map(ProductMapper::map).collect(Collectors.toList());
    }

}
