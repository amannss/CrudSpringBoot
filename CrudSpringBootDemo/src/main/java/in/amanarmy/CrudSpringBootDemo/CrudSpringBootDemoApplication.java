package in.amanarmy.CrudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


// post at postman -> controller -> service -> repository -> database

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringBootDemoApplication.class, args);

		System.out.println("hello world!");
		
	}
}	

