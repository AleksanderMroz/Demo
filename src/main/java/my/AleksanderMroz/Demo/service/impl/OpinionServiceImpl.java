package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OpinionMapper;
import my.AleksanderMroz.Demo.repository.OpinionRepository;
import my.AleksanderMroz.Demo.service.OpinionService;
import my.AleksanderMroz.Demo.to.OpinionTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpinionServiceImpl implements OpinionService {


    private OpinionRepository opinionRepository;
    @Autowired
    public OpinionServiceImpl(OpinionRepository opinionRepository){
        this.opinionRepository=opinionRepository;
    }

    @Override
    public OpinionTo saveOpinion(OpinionTo opinion) {
        opinionRepository.save(OpinionMapper.map(opinion));
        return opinion;

    }

    @Override
    public void deleteOpinion(Long id) {
        opinionRepository.deleteById(id);
    }
}
