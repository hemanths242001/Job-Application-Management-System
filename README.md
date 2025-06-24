# 🧑‍💼 Job Application Management System (Spring Boot + JWT)

A fully functional backend system for managing job listings and applications, built with **Spring Boot**, **Spring Security (JWT)**, and **PostgreSQL**. Supports **role-based access**, allowing admins to manage jobs and users to apply for them.

---

## 🚀 Features

- ✅ User Registration and Login with JWT
- 🔐 Role-based access: `ADMIN` and `USER`
- ✍️ Admins can create, update, and delete job posts
- 📄 Users can view and apply to job posts
- 🔒 Spring Security with JWT, BCrypt password hashing
- 💾 PostgreSQL integration using Spring Data JPA
- 📦 Clean layered architecture (Controller → Service → Repository)

---

## 🧰 Tech Stack

| Layer       | Technology             |
|-------------|------------------------|
| Backend     | Spring Boot, Spring Web |
| Security    | Spring Security + JWT  |
| Persistence | Spring Data JPA + PostgreSQL |
| Build Tool  | Maven |
| Utilities   | Lombok |

---

## 📂 Project Structure
com.example.jobApplicationSystem
├── config/ → Security config, JWT filters
├── controller/ → REST controllers
├── dto/ → Request/response DTOs
├── exception/ → Custom exceptions and global handler
├── model/ → Entities: User, Job, Applicant
├── repository/ → Spring JPA Repositories
├── security/ → JWT utility classes
├── service/ → Business logic layers
└── JobAppJwtApplication.java

 API Testing (via Postman)
 
🔐 Authentication
POST /api/auth/signup
POST /api/auth/login

💼 Jobs (Admin Only)
GET    /api/jobs
POST   /api/jobs
PUT    /api/jobs/{id}
DELETE /api/jobs/{id}

📩 Applications (User Only)
POST /api/jobs/{id}/apply
Include Authorization: Bearer <JWT> header for secured endpoints

