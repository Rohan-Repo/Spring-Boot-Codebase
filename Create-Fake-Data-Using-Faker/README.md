# Create Fake Data Using Faker (Spring Boot App)

This Spring Boot app generates and serves fake people data using the Faker library, ideal for development and testing.

## Technologies
- Java 8+
- Spring Boot
- Maven
- Faker
- Postman

## API Endpoints

- **Get All People:**  
  `GET /api/people/all`

- **Find by First and Last Name:**  
  `GET /api/people/findBy?fName=Devon&lName=Nolan`

- **Get SQL Query Data:**  
  `GET /api/people/details`

## Usage

1. **Clone and run:**
- git clone https://github.com/Rohan-Repo/Spring-Boot-Codebase.git 
- cd Spring-Boot-Codebase/Create-Fake-Data-Using-Faker 
- mvn clean install 
- mvn spring-boot:run
- H2 Console: http://localhost:8080/h2-console/login.do

2. **Test APIs using the included Postman Collection.**

## Contents
- Data files
- Postman Collection for API testing

## License

MIT License
