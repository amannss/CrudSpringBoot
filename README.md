[README-CrudSpringBoot.md](https://github.com/user-attachments/files/32437041/README-CrudSpringBoot.md)
# Student CRUD REST API

A simple **Student CRUD REST API** built with **Java and Spring Boot**. The project demonstrates how a REST request moves through a layered backend architecture:

**Postman → Controller → Service → Repository → MySQL**

The application manages student records and supports **Create, Read, Update, and Delete (CRUD)** operations.

---

## 🚀 Features

- Create a new student
- Get a student by ID
- Get all students
- Update an existing student
- Delete a student
- RESTful API endpoints
- MySQL database integration
- Automatic table creation/update using JPA/Hibernate
- Layered architecture using Controller, Service, Repository, and Entity
- API testing with Postman

---

## 🛠️ Tech Stack

| Technology / Tool | Purpose |
|---|---|
| **Java 21** | Programming language used to build the backend |
| **Spring Boot 4.1.1** | Framework used to create and run the REST API |
| **Spring Web MVC** | Handles HTTP requests and exposes REST endpoints |
| **Spring Data JPA** | Provides repository-based database operations without writing SQL for basic CRUD |
| **JPA (Jakarta Persistence)** | Maps Java objects/entities to database tables |
| **Hibernate** | JPA implementation that performs ORM and generates SQL |
| **JDBC** | Provides the database connectivity layer used to communicate with MySQL |
| **MySQL** | Relational database used to store student records |
| **MySQL Connector/J** | JDBC driver that allows the application to connect to MySQL |
| **Maven** | Dependency management and project build tool |
| **DBeaver** | Database management tool used to view and manage the MySQL database |
| **Postman** | Used to send and test REST API requests |
| **IntelliJ IDEA** | IDE used for development |

---

## 🏗️ Project Architecture

The project follows a simple layered architecture:

```text
                    ┌──────────────┐
                    │   Postman    │
                    └──────┬───────┘
                           │ HTTP Request
                           ▼
                 ┌────────────────────┐
                 │     Controller     │
                 │  StudentController│
                 └─────────┬──────────┘
                           │
                           ▼
                 ┌────────────────────┐
                 │      Service       │
                 │   StudentService  │
                 └─────────┬──────────┘
                           │
                           ▼
                 ┌────────────────────┐
                 │     Repository     │
                 │ StudentRepository │
                 └─────────┬──────────┘
                           │
                    JPA / Hibernate
                           │
                           ▼
                 ┌────────────────────┐
                 │       MySQL        │
                 │  student table     │
                 └────────────────────┘
```

### Request Flow

1. **Postman** sends an HTTP request.
2. **Controller** receives the request and maps it to the appropriate endpoint.
3. **Service** handles the application/business logic.
4. **Repository** communicates with the database through Spring Data JPA.
5. **JPA/Hibernate** translates entity operations into SQL.
6. **MySQL** stores or retrieves the student data.
7. The response travels back through the same layers to the client.

---

## 📂 Project Structure

```text
CrudSpringBootDemo/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── in/amanarmy/CrudSpringBootDemo/
│   │   │       │
│   │   │       ├── CrudSpringBootDemoApplication.java
│   │   │       │
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java
│   │   │       │
│   │   │       ├── service/
│   │   │       │   └── StudentService.java
│   │   │       │
│   │   │       ├── repository/
│   │   │       │   └── StudentRepository.java
│   │   │       │
│   │   │       └── entity/
│   │   │           └── Student.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

## 📌 Role of Each Layer

### 1. Main Application

`CrudSpringBootDemoApplication.java`

- Entry point of the Spring Boot application.
- Contains the `main()` method.
- `@SpringBootApplication` starts the Spring application and enables component scanning and auto-configuration.

### 2. Controller

`StudentController.java`

- Handles incoming HTTP requests.
- Defines the REST API endpoints.
- Uses annotations such as:
  - `@RestController`
  - `@RequestMapping`
  - `@PostMapping`
  - `@GetMapping`
  - `@PutMapping`
  - `@DeleteMapping`
- Calls the `StudentService` instead of directly accessing the database.

### 3. Service

`StudentService.java`

- Contains the application/business logic.
- Acts as a bridge between the Controller and Repository.
- Uses methods provided by `StudentRepository` for CRUD operations.

### 4. Repository

`StudentRepository.java`

- Data access layer.
- Extends `JpaRepository<Student, Long>`.
- Provides ready-made methods such as:
  - `save()`
  - `findById()`
  - `findAll()`
  - `existsById()`
  - `deleteById()`

This reduces the need to write SQL manually for basic CRUD operations.

### 5. Entity

`Student.java`

- Represents a student record.
- Annotated with `@Entity`.
- Mapped to the `student` table in MySQL.
- Contains:
  - `id`
  - `name`
  - `age`
  - `email`
  - `rollno`
  - `subject`

The ID uses `GenerationType.IDENTITY`, allowing MySQL to generate the primary key automatically.

---

## 🔗 REST API Endpoints

Base URL:

```text
http://localhost:8080/api/students
```

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/create` | Create a new student |
| `GET` | `/get/{id}` | Get a student by ID |
| `GET` | `/getall` | Get all students |
| `PUT` | `/update/{id}` | Update a student |
| `DELETE` | `/delete/{id}` | Delete a student |

---

## 📮 API Examples

### Create Student

**POST**

```text
http://localhost:8080/api/students/create
```

Request body:

```json
{
  "name": "Aman",
  "age": 25,
  "email": "aman@gmail.com",
  "rollno": 101,
  "subject": "Spring Framework"
}
```

The `id` is generated automatically by MySQL/JPA.

---

### Get Student by ID

**GET**

```text
http://localhost:8080/api/students/get/1
```

---

### Get All Students

**GET**

```text
http://localhost:8080/api/students/getall
```

---

### Update Student

**PUT**

```text
http://localhost:8080/api/students/update/1
```

Request body:

```json
{
  "name": "Aman Sharma",
  "age": 22,
  "email": "aman@example.com",
  "rollno": 101,
  "subject": "Spring Boot"
}
```

---

### Delete Student

**DELETE**

```text
http://localhost:8080/api/students/delete/1
```

---

## 🗄️ Database

The project uses MySQL with the database:

```text
student_crud_db
```

The application connects using a JDBC URL similar to:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
```

JPA/Hibernate is configured with:

```properties
spring.jpa.hibernate.ddl-auto=update
```

This allows Hibernate to create or update the required table structure based on the entity.

The main table is:

```text
student
```

### Student Table

| Column | Type | Description |
|---|---|---|
| `id` | BIGINT | Primary key, auto-generated |
| `name` | VARCHAR | Student name |
| `age` | INT | Student age |
| `email` | VARCHAR | Student email |
| `rollno` | INT | Student roll number |
| `subject` | VARCHAR | Student subject |

DBeaver is used to connect to MySQL and inspect/manage the database and tables.

---

## ⚙️ How to Run

### Prerequisites

Make sure you have installed:

- Java 21
- Maven
- MySQL Server
- IntelliJ IDEA
- DBeaver (optional, for database management)
- Postman (for API testing)

### 1. Clone the repository

```bash
git clone https://github.com/amannss/CrudSpringBoot.git
```

### 2. Open the project

Open the `CrudSpringBootDemo` project in IntelliJ IDEA.

### 3. Create the MySQL database

```sql
CREATE DATABASE student_crud_db;
```

### 4. Configure database credentials

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

**Do not commit your real database password to GitHub.**

### 5. Run the application

Run:

```text
CrudSpringBootDemoApplication.java
```

Or use Maven:

```bash
mvn spring-boot:run
```

The API will run on:

```text
http://localhost:8080
```

### 6. Test with Postman

Use the endpoints listed in the **REST API Endpoints** section.

---

## 🔄 CRUD Operations

The application demonstrates the four basic database operations:

```text
CREATE  → POST
READ    → GET
UPDATE  → PUT
DELETE  → DELETE
```

These operations are implemented through the flow:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
JDBC / MySQL
```

---

## 🎯 What I Learned From This Project

- Building REST APIs using Spring Boot
- Understanding Controller-Service-Repository architecture
- Dependency Injection in Spring
- Using `@RestController` and HTTP methods
- Working with `@Entity` and JPA
- Using `JpaRepository`
- Connecting Spring Boot with MySQL
- Understanding the role of JDBC and Hibernate
- Performing CRUD operations
- Testing APIs using Postman
- Managing MySQL databases using DBeaver
- Managing dependencies and building projects with Maven

---

## 👨‍💻 Author

**Aman Sharma**

GitHub: [@amannss](https://github.com/amannss)

Repository: [CrudSpringBoot](https://github.com/amannss/CrudSpringBoot)
