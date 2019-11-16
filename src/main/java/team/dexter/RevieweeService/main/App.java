package team.dexter.RevieweeService.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories("team.dexter.RevieweeService.daos")
@ComponentScan(basePackages = { "team.dexter.RevieweeService.*" })
@EntityScan("team.dexter.RevieweeService.models")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
