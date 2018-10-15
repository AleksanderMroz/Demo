package my.AleksanderMroz.Demo.service.impl;


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
        return null;
    }

    @Override
    public void deleteOutpost(Long id) {

    }
}
