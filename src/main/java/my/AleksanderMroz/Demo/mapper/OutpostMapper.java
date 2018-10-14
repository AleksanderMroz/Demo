package my.AleksanderMroz.Demo.mapper;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OutpostTo;

import java.util.List;
import java.util.stream.Collectors;

public class OutpostMapper {

    public static OutpostTo map(OutpostEntity outpostEntity)
    {
        if (outpostEntity != null) {
            return new OutpostTo(outpostEntity.getId(),outpostEntity.getLogo(),outpostEntity.getLocation());
        }
        return null;
    }

    public static OutpostEntity map(OutpostTo outpostTo)
    {
        if (outpostTo != null) {
            return new OutpostEntity(outpostTo.getId(),outpostTo.getLogo(),outpostTo.getLocation());
        }
        return null;
    }

    public static List<OutpostTo> map2To(List<OutpostEntity> outpostEntities) {
        return outpostEntities.stream().map(OutpostMapper::map).collect(Collectors.toList());
    }

    public static List<OutpostEntity> map2Entity(List<OutpostTo> outpostTos) {
        return outpostTos.stream().map(OutpostMapper::map).collect(Collectors.toList());
    }

}
