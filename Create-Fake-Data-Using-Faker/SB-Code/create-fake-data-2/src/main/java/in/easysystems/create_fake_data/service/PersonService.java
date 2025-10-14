package in.easysystems.create_fake_data.service;

import in.easysystems.create_fake_data.dto.PersonDetailsDTO;
import in.easysystems.create_fake_data.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public List<PersonDetailsDTO> getAllPersonDetails() {
        return repo.getPersonDetails();
    }
}
