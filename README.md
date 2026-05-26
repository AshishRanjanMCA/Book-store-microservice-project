# Online Book Store Microservices Project

## Project Overview

This is a fully Dockerized Java 21 Spring Boot Microservices project.

The application is designed using Microservices Architecture where each service runs independently with its own MySQL database and Docker container.

---

# Features

- Java 21
- Spring Boot 3.2+
- Dockerized Microservices
- Multi-stage Docker Builds
- Docker Compose
- MySQL Databases
- REST APIs
- Production-style Architecture
- Portable Deployment

---

# Microservices Included

| Service | Port | Database |
|----------|------|-----------|
| user-service | 8081 | userdb |
| book-service | 8082 | bookdb |
| order-service | 8083 | orderdb |

---

# Project Architecture

```text
Client
   ↓
------------------------------------------------
| user-service  → mysql-user  → userdb         |
| book-service  → mysql-book  → bookdb         |
| order-service → mysql-order → orderdb        |
------------------------------------------------


Technologies Used
Java 21
Spring Boot 3.2+
Spring Data JPA
Maven
MySQL 8
Docker
Docker Compose



Project Structure
---------------------
bookstore-microservices/
│
├── docker-compose.yml
│
├── user-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
│
├── book-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
│
└── order-service/
    ├── src/
    ├── Dockerfile
    └── pom.xml


Prerequisites
----------------------
Only Docker is required.

Install Docker:

https://www.docker.com/products/docker-desktop/

Verify installation:

docker --version
docker compose version


How To Run Project
--------------------
Clone Repository

git clone YOUR_GITHUB_REPO_URL

Go to project folder:


-------------------------
Build And Start Application
---------------------------
docker compose up --build

Docker automatically:
---------------------
Downloads Java images
Downloads MySQL images
Builds applications
Creates containers
Starts databases
Starts microservices




-------------------------


API Testing
------------
User Service
---------------
Create User

curl -X POST http://localhost:8081/users \
-H "Content-Type: application/json" \
-d '{
"name":"Ashish",
"email":"ashish@test.com"
}'

Get Users
curl http://localhost:8081/users
-------------------------------------------

Book Service
---------------
Create Book

curl -X POST http://localhost:8082/books \
-H "Content-Type: application/json" \
-d '{
"title":"Docker Book",
"price":499
}'

Get Books
curl http://localhost:8082/books

----------------------------------
Order Service
Create Order
curl -X POST http://localhost:8083/orders \
-H "Content-Type: application/json" \
-d '{
"userId":1,
"bookId":1
}'

Get Orders
curl http://localhost:8083/orders

----------------------------------------
Stop Application
--------------------
docker compose down

Remove Containers And Volumes
-------------------------------
docker compose down -v


Docker Concepts Used
-----------------------
Dockerfile
Multi-stage Build
Docker Compose
Containers
Images
Volumes
Port Mapping




Production Improvements
------------------------------------
This project can be extended with:

GitHub Actions CI/CD
Kubernetes
Prometheus
Grafana
JWT Authentication
API Gateway
Kafka
ELK Stack
Trivy Security Scanning




Learning Outcomes
----------------------

By completing this project you learn:

Microservices Architecture
Spring Boot REST APIs
Docker
Docker Compose
Container Networking
MySQL Integration
Production-style Deployment

Author
----------
Ashish Ranjan
