package my.AleksanderMroz.Demo;


import nz.net.ultraq.thymeleaf.LayoutDialect;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@ComponentScan ("my.AleksanderMroz.Demo")
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "mysql");
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
