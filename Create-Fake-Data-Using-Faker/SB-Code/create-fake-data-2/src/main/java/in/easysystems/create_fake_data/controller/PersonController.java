package in.easysystems.create_fake_data.controller;

import in.easysystems.create_fake_data.dto.PersonDetailsDTO;
import in.easysystems.create_fake_data.model.Person;
import in.easysystems.create_fake_data.repository.PersonRepository;
import in.easysystems.create_fake_data.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping( "/api/people" )
public class PersonController {

    private final PersonService service;

    private final PersonRepository personRepository;

    public PersonController(PersonService service, PersonRepository personRepository) {
        this.service = service;
        this.personRepository = personRepository;
    }

    @Operation (
            summary = "Get All Users",
            description = "Getting all the users created using our Faker Library"
    )
    // Navigate to http://localhost:8080/api/people/all
    @GetMapping("/all")
    public Iterable<Person> findAll(){
        return personRepository.findAll();
    }

    // http://localhost:8080/api/people/findBy?fName=Devon&lName=Nolan

    @Operation (
            summary = "Find Users by their firstName and lastName",
            description = "Getting specific user details"
    )
    @GetMapping("/findBy")
    public Person findByFirstAndLastName(
            @Parameter( description = "firstName of the User", required = true)
            @RequestParam String fName,
            @Parameter( description = "lastName of the User", required = true)
            @RequestParam String lName ){
        return personRepository.findByFirstNameEqualsAndLastNameEquals( fName, lName );
    }

    @Operation (
            summary = "Get SQL Query Output",
            description = "Getting specific user details"
    )
    @GetMapping("/details")
    public List<PersonDetailsDTO> getAllPersonDetails() {
        return service.getAllPersonDetails();
    }
    
}
