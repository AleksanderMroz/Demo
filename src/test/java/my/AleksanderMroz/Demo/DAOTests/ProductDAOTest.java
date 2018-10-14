package my.AleksanderMroz.Demo.DAOTests;


import my.AleksanderMroz.Demo.entity.OpinionEntity;
import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.repository.CustomerRepository;
import my.AleksanderMroz.Demo.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class ProductDAOTest {

    @Autowired
    ProductRepository productRepository;


    @Test
    public void getAllOpinions()
    {
        //given
        ProductEntity productEntity = productRepository.findById(1L).get();
        //when

       List<OpinionEntity> opinion_list= productRepository.getAllOpinions(productEntity);
        //then

        Assert.assertEquals(2,opinion_list.size());

    }


}
