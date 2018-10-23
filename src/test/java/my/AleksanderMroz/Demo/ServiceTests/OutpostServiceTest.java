package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.OutpostEntity;
import my.AleksanderMroz.Demo.enumeration.Cities;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.service.OpinionService;
import my.AleksanderMroz.Demo.service.OutpostService;
import my.AleksanderMroz.Demo.to.OutpostTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Transactional
public class OutpostServiceTest {
    @Autowired
    OutpostService outpostService;
    @Autowired
    OutpostRepository outpostRepo;


    @Test
    public void shouldAddAndRemoveOutpost()
    {

        List<OutpostEntity> list = (List<OutpostEntity>) outpostRepo.findAll();
        Assert.assertEquals(6,list.size());

        OutpostTo outpostTo = new OutpostTo(null,"NUKACOLA", Cities.WROCLAW);
        outpostService.saveOutpost(outpostTo);

        list = (List<OutpostEntity>) outpostRepo.findAll();
        Assert.assertEquals(7,list.size());

        outpostService.deleteOutpost(7L);
        list = (List<OutpostEntity>) outpostRepo.findAll();
        Assert.assertEquals(6,list.size());
    }
}
