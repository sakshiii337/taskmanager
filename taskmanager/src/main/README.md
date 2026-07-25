# 📋 Task Manager REST API

A backend REST API built using **Java**, **Spring Boot**, and **PostgreSQL** to efficiently manage users and their tasks. The application follows a layered architecture and provides RESTful endpoints for task and user management with validation, pagination, DTO mapping, and exception handling.

---

## 🚀 Features

* 👤 User Management (CRUD Operations)
* ✅ Task Management (CRUD Operations)
* 🔗 Assign Tasks to Users
* 📄 Pagination Support
* 🔄 DTO Mapping using ModelMapper
* ✔️ Request Validation
* ⚠️ Global Exception Handling
* 🗄️ PostgreSQL Database Integration
* 🏗️ Layered Architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Lombok
* ModelMapper

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── dto
├── exception
├── config
└── resources
```

---

## 🗃️ Database

* PostgreSQL
* Spring Data JPA
* Hibernate ORM

---

## 📌 REST API Endpoints

### User APIs

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/users`      | Create a new user |
| GET    | `/users`      | Get all users     |
| GET    | `/users/{id}` | Get user by ID    |
| PUT    | `/users/{id}` | Update user       |
| DELETE | `/users/{id}` | Delete user       |

---

### Task APIs

| Method | Endpoint      | Description       |
| ------ | ------------- | ----------------- |
| POST   | `/tasks`      | Create a new task |
| GET    | `/tasks`      | Get all tasks     |
| GET    | `/tasks/{id}` | Get task by ID    |
| PUT    | `/tasks/{id}` | Update task       |
| DELETE | `/tasks/{id}` | Delete task       |

---

## ⚙️ How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/sakshiii337/taskmanager.git
```

### 2. Navigate to the Project

```bash
cd taskmanager
```

### 3. Configure Database

Update the following properties in `application.properties`:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

or run `TaskmanagerApplication.java` directly from your IDE.

---

## 📦 Dependencies

* Spring Boot Starter Web
* Spring Boot Starter Data JPA
* PostgreSQL Driver
* Lombok
* ModelMapper
* Spring Boot Validation

---

## 🏛️ Architecture

The project follows a layered architecture:

```text
Client
   │
Controller
   │
Service
   │
Repository
   │
PostgreSQL Database
```

---

## 🔮 Future Enhancements

* 🔐 Spring Security
* 🔑 JWT Authentication
* 👥 Role-Based Authorization
* 📖 Swagger / OpenAPI Documentation
* 🐳 Docker Support
* ☁️ Cloud Deployment
* 📊 Unit & Integration Testing

---

## 📚 Concepts Used

* RESTful API Design
* Dependency Injection
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* DTO Pattern
* Pagination
* Exception Handling
* Validation
* Entity Relationships
* Layered Architecture

---

## 👩‍💻 Author

**Sakshi Patel**

GitHub: https://github.com/sakshiii337

---

⭐ If you found this project useful, consider giving it a star!
