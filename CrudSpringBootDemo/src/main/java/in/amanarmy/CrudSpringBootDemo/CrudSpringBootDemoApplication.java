package in.amanarmy.CrudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudSpringBootDemoApplication.class, args);

		System.out.println("hello world!");
		
	}
// post at postman -> controller -> service -> repository -> database

}	

// for postman
//{
//		"id" : 1 ,
//		"name" : "aman" ,
//		"age" : 15,
//		"email" : "aman@gmail.com" ,
//		"rollno" : 17 ,
//		"subject" : "science"
//}
//
// http://localhost:8080/api/students/create