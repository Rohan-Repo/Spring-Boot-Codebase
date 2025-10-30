# ShowCastDB CRUD REST API

A Spring Boot REST API for streamlined CRUD management of TV show cast and actor information, featuring interactive docs via Swagger UI and ready-to-use Postman collection.

---

## Overview

This API enables the creation, reading, updating, and deletion (CRUD) of TV show cast and actor records. The backend service uses Spring Boot, JPA, and PostgreSQL, with OpenAPI/Swagger integration for seamless API documentation and testing.

---

## Tech Stack

- **Spring Boot 4**
- **Spring Data JPA**
- **PostgreSQL**
- **Springdoc OpenAPI/Swagger UI**
- **Postman (for test collection)**
- **Java 21** (configurable via `pom.xml`)

---

## Running the Project

1. **Clone the Repository**

1. **Clone and Run:**
git clone https://github.com/Rohan-Repo/Spring-Boot-Codebase.git
cd Spring-Boot-Codebase/SB-REST-API-PostGreSQL/SB-Code/showcastdb-rest-api

2. **Build and Start**

mvn clean install
mvn spring-boot:run


3. **PostgreSQL Setup**

Ensure your PostgreSQL is running, Database and the User is created before starting the Coding and configured in your `application.properties`. PostgreSQL DB Configrtaion file is separate `application-postgresql.properties`.

---

## API Endpoints

| Method | Endpoint                        | Description                                           |
|--------|---------------------------------|-------------------------------------------------------|
| GET    | `/api/showactors`               | List all actors in the database                       |
| POST   | `/api/showactors`               | Add a new actor (show name, role, real name)          |
| GET    | `/api/showactors/{id}`          | Retrieve actor details by unique UUID                 |
| PUT    | `/api/showactors/{id}`          | Update actor information (all fields)                 |
| PATCH  | `/api/showactors/{id}`          | Update an actor's character name                      |
| DELETE | `/api/showactors/{id}`          | Remove an actor from the database                     |

- Actor objects require: `actorID`, `showName`, `actorShowName`, `actorRealName`
- All requests and responses follow OpenAPI schema (see API docs)

---

## API Documentation

- **Swagger UI**  
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

- **OpenAPI Docs**  
[http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## Testing the API

- Import the Postman collection:  
`SB-CRUD-Rest-API-Collection.postman_collection.json`
- Example requests for creating, updating, deleting, and fetching actors are provided for quick testing.

---

## References

- YouTube: REST API Tutorial  
[https://www.youtube.com/watch?v=aKIqlatqpX8](https://www.youtube.com/watch?v=aKIqlatqpX8)
- YouTube: Swagger/OpenAPI Tutorial  
[https://www.youtube.com/watch?v=bvhpje9sl6E](https://www.youtube.com/watch?v=bvhpje9sl6E)

---

## Files Included

- `pom.xml` - All dependencies preconfigured for Spring Boot, Spring Data JPA, Swagger/OpenAPI, and PostgreSQL
- `crud-REST-api-docs-final.json` - OpenAPI/Swagger spec for endpoints and models
- `SB-CRUD-Rest-API-Collection.postman_collection.json` - Postman collection for quick API testing

---

## License

Apache-2.0 License