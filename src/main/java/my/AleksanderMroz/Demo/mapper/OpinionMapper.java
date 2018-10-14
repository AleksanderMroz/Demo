package my.AleksanderMroz.Demo.mapper;

import my.AleksanderMroz.Demo.entity.CustomerEntity;
import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OpinionTo;

import java.util.List;
import java.util.stream.Collectors;

public class OpinionMapper {

    public static OpinionTo map(OpinionEntity opinionEntity)
    {
        if (opinionEntity != null) {
            return new OpinionTo(opinionEntity.getId(),opinionEntity.getDescription(),opinionEntity.getDescribed_product(),opinionEntity.getCustomer_id());
        }
        return null;
    }

    public static OpinionEntity map(OpinionTo opinionTo)
    {
        if (opinionTo != null) {
            return new OpinionEntity(opinionTo.getId(),opinionTo.getDescription(),opinionTo.getDescribed_product(),opinionTo.getCustomer_id());
        }
        return null;
    }

    public static List<OpinionTo> map2To(List<OpinionEntity> opinionEntities) {
        return opinionEntities.stream().map(OpinionMapper::map).collect(Collectors.toList());
    }

    public static List<OpinionEntity> map2Entity(List<OpinionTo> opinionTos) {
        return opinionTos.stream().map(OpinionMapper::map).collect(Collectors.toList());
    }
}
