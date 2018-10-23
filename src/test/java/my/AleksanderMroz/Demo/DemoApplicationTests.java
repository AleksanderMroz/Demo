package my.AleksanderMroz.Demo;

import my.AleksanderMroz.Demo.DAOTests.*;
import my.AleksanderMroz.Demo.DAOTests.MapperTests;
import my.AleksanderMroz.Demo.ServiceTests.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
@Suite.SuiteClasses({CourierServiceTest.class,
        CustomerServiceTest.class,
        OpinionServiceTest.class,
        OutpostServiceTest.class,
        ProductServiceTest.class,
        ShipmentServiceTest.class,
        MapperTests.class,
        BasicDAOTests.class,
        CourierDAOTest.class,
        CustomerDAOTest.class,
        ProductDAOTest.class,
        ShipmentDAOTest.class})
public class DemoApplicationTests {
}
