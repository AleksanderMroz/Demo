package my.AleksanderMroz.Demo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class CustomerDAOTest {


    @Test
    public void trueIsTrue()
    {
        Assert.assertTrue(true);
    }

}
