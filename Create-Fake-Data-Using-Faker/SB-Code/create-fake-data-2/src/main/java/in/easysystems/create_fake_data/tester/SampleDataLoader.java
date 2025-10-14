package in.easysystems.create_fake_data.tester;

import com.github.javafaker.Faker;
import in.easysystems.create_fake_data.model.Address;
import in.easysystems.create_fake_data.model.Person;
import in.easysystems.create_fake_data.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final PersonRepository personRepository;
    // Instead of us creating it in the Constructor we created via the Bean inside WebConfig
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        // this.faker = new Faker(); - By default gives USA based Data
        // this.faker = new Faker( new Locale("en-CA") );
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> people =
                IntStream
                        .rangeClosed( 1, 100 )
                        .mapToObj( p -> new Person(
                                faker.name().firstName(),
                                faker.name().lastName(),
                                faker.date().birthday()
                                        .toInstant()
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate(),
                                faker.phoneNumber().cellPhone(),
                                faker.internet().emailAddress(),
                                new Address(
                                        faker.address().streetAddress(),
                                        faker.address().city(),
                                        faker.address().state(),
                                        faker.address().zipCode()
                                )
                        )).collect( Collectors.toList() );

        personRepository.saveAll( people );

    }
}
