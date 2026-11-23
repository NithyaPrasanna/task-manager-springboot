# Task Manager — Spring Boot CRUD Application

A full-stack Task Management web application built using **Java**, **Spring Boot**, **Spring Data JPA**, **H2 Database**, and **HTML/CSS/JavaScript**. This project demonstrates end-to-end RESTful API development and frontend-backend integration.

## Features
- **Create Tasks:** Add new tasks with a title and description.
- **Update & Complete:** Edit existing task titles and descriptions or toggle completion status.
- **Delete Tasks:** Remove tasks permanently from the database.
- **Database Console:** Built-in H2 database console for inspecting tables and SQL queries.

## Tech Stack
- **Backend:** Java 21, Spring Boot, Spring Web (REST API), Spring Data JPA (Hibernate)
- **Database:** H2 Database (Persistent file storage)
- **Frontend:** HTML5, CSS3, Vanilla JavaScript (`fetch` API)
- **Build Tool:** Maven

## Project Structure
```text
src/main/java/com/project/taskmanager
├── controller   # REST API endpoints (@RestController)
├── service      # Business logic and validation (@Service)
├── repository   # Spring Data JPA interface (JpaRepository)
└── model        # JPA Entity mapping (Task)
src/main/resources
├── static       # Frontend UI (index.html)
└── application.properties
```

## How to Run Locally
1. Clone the repository:
   ```bash
   git clone https://github.com
   ```
2. Open the project in **Eclipse** or **IntelliJ IDEA** as an **Existing Maven Project**.
3. Run `TaskmanagerApplication.java`.
4. Open your browser and visit:
   - **Web App:** `http://localhost:8080`
   - **H2 Database Console:** `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:file:./data/mydb`, User: `sa`, Password: *(blank)*)

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/tasks` | Get all tasks (supports `?completed=true` or `?completed=false`) |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update an existing task |
| `DELETE` | `/api/tasks/{id}` | Delete a task by ID |
