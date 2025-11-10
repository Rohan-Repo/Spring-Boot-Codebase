package in.easysystems.showcastdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Entity : Package to add all of our JPA Entities
//DTO : Use the Data-Transfer-Object classes to transfer data between Client and Server
//Repository : Package to add all of our Spring Data JPA Repositories
//Service : Package to hold service classes which hold our Business Logic
//Controller :  Package to add all of our Spring REST Controllers
//Mapper : Package to hold mapper classes which map our JPA Entities to DTO's and Vice versa
//Exception : Package to add all of our Custom Exceptions

@SpringBootApplication
public class ShowcastdbRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowcastdbRestApiApplication.class, args);
	}

}
