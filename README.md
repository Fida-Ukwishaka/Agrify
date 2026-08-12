# Farm Management System Backend

Simple Spring Boot backend using Java, Maven, JDBC and MariaDB. No ORM/JPA/Hibernate.

## Architecture

Controller -> Service -> DAO -> JdbcTemplate -> MariaDB

DTOs are used for request data. Models represent database rows.

## Database

1. Open MariaDB/HeidiSQL.
2. Run `database/farm_management.sql`.
3. The script keeps the supplied SQL and adds four missing tables required by the supplied sale-item SQL, triggers and procedure:
   - inventory
   - sale
   - payment
   - inventory_transaction
4. All IDs are CHAR(36) UUIDs.

## Configuration

Open `src/main/resources/application.properties` and change:

`spring.datasource.password=YOUR_MARIADB_PASSWORD`

## Run without installing Maven globally on Windows

Java is required. From the project root run:

`.\mvnw.cmd spring-boot:run`

The included Windows helper downloads Apache Maven into your user folder the first time it is used.

## Swagger

After startup open:

http://localhost:8080/swagger-ui.html

Use Swagger's Authorize button.

Development admin:

- username: `admin`
- password: `admin123`
- role: ADMIN

The admin is created automatically if it does not already exist.

## Authentication

This project uses Spring Security HTTP Basic Authentication with BCrypt passwords. This is intentionally simple and easy to explain.

- `POST /api/auth/register` is public.
- Other `/api/**` endpoints require authentication.
- `/api/accounts/**` requires ADMIN.

## Main endpoint pattern

For example:

GET `/api/farm`
GET `/api/farm/{id}`
POST `/api/farm`
PUT `/api/farm/{id}`
DELETE `/api/farm/{id}`

The same simple pattern is used for the other CRUD resources.

## Sale items

`POST /api/sale-items` calls the supplied `sp_record_sale_item` stored procedure. The database procedure calculates the subtotal and updates the sale total. The supplied triggers also protect inventory and create inventory transactions.
