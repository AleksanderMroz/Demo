package my.AleksanderMroz.Demo.service.impl;


import my.AleksanderMroz.Demo.entity.CourierEntitiy;
import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.mapper.CourierMapper;
import my.AleksanderMroz.Demo.mapper.OutpostMapper;
import my.AleksanderMroz.Demo.repository.OutpostRepository;
import my.AleksanderMroz.Demo.service.OutpostService;
import my.AleksanderMroz.Demo.to.OutpostTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutpostServiceImpl implements OutpostService {
    private OutpostRepository outpostRepository;

    @Autowired
    public OutpostServiceImpl(OutpostRepository outpostRepository)
    {
        this.outpostRepository=outpostRepository;
    }

    @Override
    public OutpostTo saveOutpost(OutpostTo outpost) {
        OutpostEntity outpostEntitiy = OutpostMapper.map(outpost);
        outpostRepository.save(outpostEntitiy);
        return outpost;
    }

    @Override
    public void deleteOutpost(Long id) {
        outpostRepository.deleteById(id);
    }
}
