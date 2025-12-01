# Spring-Boot-Codebase

A curated collection of Spring Boot projects to showcase practical expertise in building Java backend applications. This repository features RESTful APIs, fake data generators, and sample integrations—ideal for learning, demonstrations, and template use.

---

## Projects Included

### 1. **ShowCastDB CRUD REST API**
- A complete CRUD API for managing TV show cast and actor data.
- Stack: Spring Boot, Spring Data JPA, PostgreSQL, MySQL, MS-SQL Server, Swagger/OpenAPI
- Features interactive Swagger UI and ready-to-import Postman collection.
- Example Endpoints:
    - `GET /api/showactors` – List all actors
    - `POST /api/showactors` – Create actor
    - Other endpoints for update, partial update, delete

### 2. **Fake Data Generator API Using Faker**
- REST API for generating and serving random people data using the Faker library.
- Stack: Spring Boot, H2 Database, MySQL Database, Faker, Maven
- Sample endpoints:
    - `GET /api/people/all` – List all fake people
    - `GET /api/people/findBy?fName=Devon&lName=Nolan` – Search by name
    - `GET /api/people/details` – Get extended details

---

## Key Features

- Spring Boot project structure and best practices
- Comprehensive OpenAPI/Swagger documentation for all APIs
- Postman collections provided for instant API testing
- Uses Faker for realistic test data creation
- Includes examples for database integration (JPA/SQL, H2, PostgreSQL, MySQL)
- Licensed under Apache-2.0

---

## Quick Start

1. **Clone this repository**

git clone https://github.com/Rohan-Repo/Spring-Boot-Codebase.git

2. **Navigate to your project of choice**
- For CRUD API:  
  `cd Spring-Boot-Codebase/Spring-Boot-CRUD-REST-API`
- For Faker API:  
  `cd Spring-Boot-Codebase/Create-Fake-Data-Using-Faker`
3. **Run with Maven**

mvn clean install
mvn spring-boot:run


4. **Test APIs in browser or Postman**  
- API Docs (Swagger): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)  
- OpenAPI Docs: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)  

---

## References

- Video guides for REST API development and Swagger
- [REST API Fundamentals](https://www.youtube.com/watch?v=aKIqlatqpX8)
- [Swagger/OpenAPI Integration](https://www.youtube.com/watch?v=bvhpje9sl6E)
- [Faker Data Examples](https://www.youtube.com/watch?v=UzBOv_SHUng)

---

## License

Apache-2.0 License
