package my.AleksanderMroz.Demo.mapper;

import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.to.CourierTo;


import java.util.List;
import java.util.stream.Collectors;

public class CourierMapper {


    public static CourierTo map(CourierEntitiy courierEntity)
    {
        if (courierEntity != null) {
            return new CourierTo(courierEntity.getId(),courierEntity.getCourierName(),courierEntity.getPassword(),courierEntity.getAddress(),courierEntity.getShipments());
        }
        return null;
    }

    public static CourierEntitiy map(CourierTo courierTo)
    {
        if (courierTo != null) {
            return new CourierEntitiy(courierTo.getId(),courierTo.getCourierName(),courierTo.getPassword(),courierTo.getAddress(),courierTo.getShipments());
        }
        return null;
    }

    public static List<CourierTo> map2To(List<CourierEntitiy> courierEntities) {
        return courierEntities.stream().map(CourierMapper::map).collect(Collectors.toList());
    }

    public static List<CourierEntitiy> map2Entity(List<CourierTo> couriersTos) {
        return couriersTos.stream().map(CourierMapper::map).collect(Collectors.toList());
    }
}
