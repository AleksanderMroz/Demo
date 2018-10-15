package my.AleksanderMroz.Demo.ServiceTests;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=mysql")
public class ShipmentServiceTest {
}
