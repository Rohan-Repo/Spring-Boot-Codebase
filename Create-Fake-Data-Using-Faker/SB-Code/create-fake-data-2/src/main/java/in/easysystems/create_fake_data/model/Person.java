package in.easysystems.create_fake_data.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.StringJoiner;

@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate birthDate;
    private String phoneNumber;
    private String emailAddress;

    // One Person can have many Addresses
    @OneToOne( cascade = CascadeType.ALL )
    // Foreign Key Column name = address_id
    @JoinColumn( name = "address_id", referencedColumnName = "id" )
    private Address address;

    public Person() {     }
    public Person(String firstName, String lastName, LocalDate birthDate, String phoneNumber, String emailAddress, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        // Calculate Age
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("age=" + age)
                .add("birthDate=" + birthDate)
                .add("phoneNumber='" + phoneNumber + "'")
                .add("emailAddress='" + emailAddress + "'")
                .add("address=" + address)
                .toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
