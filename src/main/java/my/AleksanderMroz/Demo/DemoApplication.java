package my.AleksanderMroz.Demo;


import my.AleksanderMroz.Demo.controller.HomeController;
import nz.net.ultraq.thymeleaf.LayoutDialect;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "mysql");
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
