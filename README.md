# Gym Management System

A backend REST API for managing gym stuff — members, subscriptions, that kind of thing. Built with Spring Boot, uses JWT for auth, and MySQL to store everything.

I built this to get more hands-on with Spring Security and clean architecture patterns like DTOs and MapStruct. Still a work in progress but the core is working.

## Stack

- Java 21
- Spring Boot 4.0.6
- Spring Security + JWT (jjwt 0.12.3)
- Spring Data JPA + MySQL
- MapStruct (entity ↔ DTO mapping)
- Lombok
- Spring Validation

## Running It Locally

You'll need Java 21+, Maven, and a MySQL instance running.

```bash
git clone https://github.com/obada-hash/Gym-Management-System.git
cd Gym-Management-System
```

Set up your database and add your credentials to `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gym_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Also set a JWT secret:

```properties
jwt.secret=your_secret_key
jwt.expiration=86400000
```

Then just run:

```bash
./mvnw spring-boot:run
```

App starts at `http://localhost:8080`.

## Auth

Login/register to get a JWT token, then pass it in the header for any protected route:

```
Authorization: Bearer <token>
```

## Project Structure

```
src/main/java/com/obada/Gym_management_system/
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── mapper/
└── security/
```

## Tests

```bash
./mvnw test
```

## Author

Obada — [github.com/obada-hash](https://github.com/obada-hash)