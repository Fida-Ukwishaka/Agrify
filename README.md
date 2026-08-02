# Agricultural-Farm-Management-System

# 🌾 Agrify - Agriculture Farm Management System

Agrify is a Spring Boot REST API developed to simplify the management of commercial farms. The system allows farm administrators to manage farms, workers, crops, equipment, fertilizer inventory, harvests, customers, and sales through a secure RESTful API.

The project was developed as part of a Database Systems course to demonstrate database design, backend development, and REST API implementation using Spring Boot.

---

## Features

- Farm management
- Worker management
- Crop management
- Equipment management
- Fertilizer inventory management
- Harvest tracking
- Customer management
- Sales management
- CRUD operations for all entities
- Role-based authentication using Spring Security
- API documentation with Swagger/OpenAPI
- Global exception handling
- DTO mapping using MapStruct
- Input validation using Jakarta Validation

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- MariaDB
- Hibernate
- MapStruct
- Lombok
- Jakarta Validation
- Swagger (Springdoc OpenAPI)
- Maven

---

## Project Structure

```
src
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── enums
├── exception
├── mapper
├── repository
├── security
├── service
│   ├── interfaces
│   └── impl
└── config
```

---

## Security

The application uses Spring Security with HTTP Basic Authentication.

Two user roles are supported:

- **ADMIN** – Full access to all API endpoints
- **WORKER** – Read-only access to permitted resources

Passwords are securely stored using BCrypt password encoding.

---

## API Documentation

After running the application, Swagger UI can be accessed at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Database

The application uses MariaDB with Hibernate (JPA) for object-relational mapping.

Database schema generation is handled automatically by Hibernate during application startup.

---

## Running the Application

1. Clone the repository

```bash
git clone https://github.com/Fida-Ukwishaka/Agrify.git
```

2. Configure your MariaDB connection in `application.yml`.

3. Run the Spring Boot application.

4. Open Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Authors

Developed by:

- **Fida Ukwishaka**
