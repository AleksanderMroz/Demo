package my.AleksanderMroz.Demo.ServiceTests;


import my.AleksanderMroz.Demo.entity.ProductEntity;
import my.AleksanderMroz.Demo.enumeration.SizeStatus;
import my.AleksanderMroz.Demo.enumeration.VariantStatus;
import my.AleksanderMroz.Demo.mapper.ProductMapper;
import my.AleksanderMroz.Demo.repository.*;
import my.AleksanderMroz.Demo.service.CustomerService;
import my.AleksanderMroz.Demo.service.ProductService;
import my.AleksanderMroz.Demo.to.OpinionTo;
import my.AleksanderMroz.Demo.to.ProductTo;
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
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepo;


    @Test
    public void shouldAddAndRemove()
    {
        //given
        List<ProductEntity> list = (List<ProductEntity>) productRepo.findAll();
        Assert.assertEquals(21,list.size());

        //when
        ProductTo productTo = new ProductTo(null,10000, SizeStatus.S, VariantStatus.CUSTOMSHAPE,null,null);
        productService.saveProduct(productTo);

        //then
        list = (List<ProductEntity>) productRepo.findAll();
        Assert.assertEquals(22,list.size());


        //when
        productService.deleteProduct(22L);
        //then
        list = (List<ProductEntity>) productRepo.findAll();
        Assert.assertEquals(21,list.size());
    }

    @Test
    public void shouldGetAllOpinions()
    {
        //given
        ProductTo productTo = ProductMapper.map(productRepo.findById(1L).get());
        //when
        List<OpinionTo> list_of_opinions = productService.getAllOpinions(productTo);
        //then
        Assert.assertEquals(2,list_of_opinions.size());

    }
}
