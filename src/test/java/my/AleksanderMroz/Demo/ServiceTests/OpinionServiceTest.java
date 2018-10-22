package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.service.OpinionService;
import my.AleksanderMroz.Demo.to.CustomerTo;
import my.AleksanderMroz.Demo.to.OpinionTo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")


public class OpinionServiceTest {

    @Autowired
    OpinionService opinionService;
    @Autowired
    OpinionRepository opinionRepo;



    @Test
    public void shouldAddAndRemoveCustomer()
    {
        //given
        List<OpinionEntity> list = (List<OpinionEntity>) opinionRepo.findAll();
        Assert.assertEquals(8,list.size());


        //when
        OpinionTo opinionTo = new OpinionTo(null,"Something",null,null);
        opinionService.saveOpinion(opinionTo);
        //then
        list = (List<OpinionEntity>) opinionRepo.findAll();
        Assert.assertEquals(9,list.size());


        //when
        opinionService.deleteOpinion(9L);

        //then
        list = (List<OpinionEntity>) opinionRepo.findAll();
        Assert.assertEquals(8,list.size());
    }



}
