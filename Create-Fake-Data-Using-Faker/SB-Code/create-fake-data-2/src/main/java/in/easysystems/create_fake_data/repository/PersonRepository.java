package in.easysystems.create_fake_data.repository;

import in.easysystems.create_fake_data.dto.PersonDetailsDTO;
import in.easysystems.create_fake_data.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// CrudRepository of Type Person and Primary Key = ID is an Integer
public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByFirstNameEqualsAndLastNameEquals( String firstName, String lastName);


    @Query("""
    SELECT new in.easysystems.create_fake_data.dto.PersonDetailsDTO(
        CONCAT(p.firstName, ' ', p.lastName),
        p.birthDate,
        p.age,
        p.emailAddress,
        p.phoneNumber,
        a.address,
        a.city,
        a.state,
        a.zip
    )
    FROM Person p
    JOIN p.address a
    ORDER BY p.age DESC
""")
    List<PersonDetailsDTO> getPersonDetails();
}
