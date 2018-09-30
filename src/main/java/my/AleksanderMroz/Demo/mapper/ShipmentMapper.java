//package my.AleksanderMroz.Demo.mapper;
//
//import my.AleksanderMroz.Demo.entity.ShipmentEntity;
//import my.AleksanderMroz.Demo.to.ShipmentTo;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ShipmentMapper {
//
//    public static ShipmentTo map(ShipmentEntity shipmentEntity) {
//        if (shipmentEntity != null) {
//            return new ShipmentTo(shipmentEntity.getId(),shipmentEntity.getDestination(),shipmentEntity.getValue(),shipmentEntity.getStatus(),shipmentEntity.getOwner() );
//        }
//        return null;
//    }
//
//    public static ShipmentEntity map(ShipmentTo shipmentTo) {
//        if (shipmentTo != null) {
//            return new ShipmentEntity(shipmentTo.getId(), shipmentTo.getDestination(),shipmentTo.getValue(),shipmentTo.getStatus(),shipmentTo.getOwner());
//        }
//        return null;
//    }
//
//    public static List<ShipmentTo> map2To(List<ShipmentEntity> shipmentEntities) {
//        return shipmentEntities.stream().map(ShipmentMapper::map).collect(Collectors.toList());
//    }
//
//    public static List<ShipmentEntity> map2Entity(List<ShipmentTo> shipmentTos) {
//        return shipmentTos.stream().map(ShipmentMapper::map).collect(Collectors.toList());
//    }
//
//}
