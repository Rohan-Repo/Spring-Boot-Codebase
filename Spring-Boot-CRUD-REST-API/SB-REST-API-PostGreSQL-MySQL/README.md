# ShowCastDB CRUD REST API

A Spring Boot REST API for streamlined CRUD management of TV show cast and actor information, featuring interactive docs via Swagger UI and ready-to-use Postman collection.

---

## Overview

This API enables the creation, reading, updating, and deletion (CRUD) of TV show cast and actor records. The backend service uses Spring Boot, JPA, MySQLDB and PostgreSQL, with OpenAPI/Swagger integration for seamless API documentation and testing.

---

## Tech Stack

- **Spring Boot 4**
- **Spring Data JPA**
- **PostgreSQL**
- **MySQL**
- **Springdoc OpenAPI/Swagger UI**
- **Postman (for test collection)**
- **Java 21** (configurable via `pom.xml`)

---

## Running the Project

1. **Clone the Repository**

1. **Clone and Run:**
   
git clone https://github.com/Rohan-Repo/Spring-Boot-Codebase.git <br />
cd Spring-Boot-Codebase/Spring-Boot-CRUD-REST-API/SB-REST-API-PostGreSQL-MySQL/SB-Code/showcastdb-rest-api <br />

3. **Build and Start**

mvn clean install <br />
mvn spring-boot:run <br />

---

## Database Profile Selection and Setup

To select the database profile for the application, specify `spring.profiles.active=postgresql` in the `application.properties` file to use PostgreSQL, or `spring.profiles.active=mysql` to use MySQL. <br />
**Separate `application-mysql.properties` and `application-postgresql.properties` files already created**

- **MySQL:** Only the database user must be created manually; both the database and tables are automatically managed by Spring Boot JPA.
- **PostgreSQL:** You must manually create both the user and the database, while Spring Boot JPA will handle table creation.
---

## API Endpoints

| Method | Endpoint                        | Description                                           |
|--------|---------------------------------|-------------------------------------------------------|
| GET    | `/api/showactors`               | List all actors in the database                       |
| POST   | `/api/showactors`               | Add a new actor (show name, role, real name)          |
| GET    | `/api/showactors/{id}`          | Retrieve actor details by unique UUID                 |
| GET    | `/api/showactors/details`       | Retrieve actor details without the actorID field      |
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

- `pom.xml` - All dependencies preconfigured for Spring Boot, Spring Data JPA, Swagger/OpenAPI, MySQLDB and PostgreSQLDB
- `crud-REST-api-docs-final.json` - OpenAPI/Swagger spec for endpoints and models
- `SB-CRUD-Rest-API-Collection.postman_collection.json` - Postman collection for quick API testing

---

## License

Apache-2.0 License
