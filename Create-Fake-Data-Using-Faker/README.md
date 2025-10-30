# Create Fake Data Using Faker and Spring Boot REST API

A comprehensive Spring Boot REST API project for generating, querying, and managing fake people data using the Faker library. This system is ideal for development, testing, and sample data workflows, and features complete OpenAPI documentation and Postman collection for instant testing.

---

## Overview

This app exposes a set of GET endpoints to access randomly generated user data (name, address, contacts, etc.). Data generation is powered by the Faker library. Interactive documentation is included via Swagger UI and OpenAPI, with Postman collection for testing.

---

## Technologies Used

- **Java 8+ / 21**
- **Spring Boot**
- **Maven**
- **Faker Library**
- **H2 Database (in-memory)**
- **Swagger/OpenAPI**
- **Postman**

---

## API Endpoints

| Method | Endpoint                                        | Description                                               |
|--------|-------------------------------------------------|-----------------------------------------------------------|
| GET    | `/api/people/all`                               | Get all fake people                                       |
| GET    | `/api/people/findBy?fName=Devon&lName=Nolan`    | Find user by firstName and lastName (query params)        |
| GET    | `/api/people/details`                           | Get SQL query output with extended person details         |

- All endpoints can be tested with the included Postman collection (`FakeData-API-Collection.postman_collection.json`).


## Getting Started

1. **Clone and Run:**
git clone https://github.com/Rohan-Repo/Spring-Boot-Codebase.git
cd Spring-Boot-Codebase/Create-Fake-Data-Using-Faker
mvn clean install
mvn spring-boot:run


2. **Useful Local URLs**
- **Swagger UI:**  
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **API Docs (OpenAPI):**  
  [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- **H2 Console:**  
  [http://localhost:8080/h2-console/login.do](http://localhost:8080/h2-console/login.do)

3. **Test using Postman**
- Import `FakeData-API-Collection.postman_collection.json` into Postman
- Hit endpoints as per above

---

## API Documentation

- Full endpoint documentation and data schemas available in:
 - `api-docs-final.json` (OpenAPI definition)
 - Swagger UI at `/swagger-ui/index.html`

---

## References

- Swagger/OpenAPI Integration  
[YouTube: bvhpje9sl6E](https://www.youtube.com/watch?v=bvhpje9sl6E)
- Video tutorial for data generation  
[Dan Vega: UzBOv_SHUng](https://www.youtube.com/watch?v=UzBOv_SHUng)

---

## Contents

- `pom.xml` for all dependencies (Spring Boot, Faker, Swagger, H2 DB)
- `api-docs-final.json` for endpoint and schema reference
- `FakeData-API-Collection.postman_collection.json` for instant API testing

---

## License

Apache-2.0 License

---