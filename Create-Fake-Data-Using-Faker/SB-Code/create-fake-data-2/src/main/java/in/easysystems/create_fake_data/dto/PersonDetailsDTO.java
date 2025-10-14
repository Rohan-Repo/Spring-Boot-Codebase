package in.easysystems.create_fake_data.dto;

import java.time.LocalDate;

public record PersonDetailsDTO(
        String personName,
        LocalDate birthDate,
        Integer age,
        String emailAddress,
        String phoneNumber,
        String address,
        String city,
        String state,
        String zip
) {}
