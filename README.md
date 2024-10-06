# Candidate Service - SpringBoot - DB - Redis Cache with Docker

## Overview

This project is a **Spring Boot** application that manages candidate data, with **MySQL** as the database and **Redis** as a caching layer to improve performance. The services are containerized using **Docker** for easy deployment and orchestration.

## Prerequisites
Before running the application, ensure you have the following installed:

- **Java 17**
- **Maven 3.6+**
- **Postman** (for testing the API)
- **Docker**
- **Docker Compose**

## Project Structure

```
. 
├── candidate-service # Contains the Spring Boot Candidate Service 
│ ├── src/               # Application source code 
| ├── pom.xml 
│ ├── Dockerfile         # Dockerfile for Candidate Service 
├── database-service     # Contains MySQL service configuration 
│ ├── sql/               # SQL initialization scripts for creating database and tables 
│ ├── Dockerfile         # Dockerfile for MySQL Service 
├── docker-compose.yml   # Orchestrates all the services 
└── README.md            # Project documentation
```

## Technologies
The following technologies are used in this application:

- **Java 17**: Programming language used to develop the backend
- **Spring Boot**: Framework for building Java-based applications
- **Maven**: Build and dependency management
- **MySQL**: Database used for storing 
- **Redis**: Used for storing in-memory cache
- **Docker**: Build and dependency management
- **Docker Compose**: Orchestrates all the services


## App Features
- **Spring Boot** for rapid development and scalable architecture
- **MySQL** as the relational database for storing candidate data
- **Redis** as the caching solution to reduce database load
- **Docker** to containerize the services for easy deployment
  
## Example of APIs and Expected Outputs

### 1. Create candidate API
**Endpoint**: `POST /candidate/create`

**Request Body**:
```json
{
    "id":1,
    "name":"Reshma Salunkhe",
    "designation":"Software Engineer",
    "organisationName":"Hopscotch",
    "yearsOfExperience":6
}
```

**Response Body**
```
{
    "candidate": {
        "candidateId": 1,
        "candidateName": "Reshma Salunkhe",
        "organisationName": "Hopscotch",
        "designation": "Software Engineer",
        "yearsOfExperience": 6.0
    },
    "message": "Candidate created successfully"
}
```
### 2. Get candidate API
**Endpoint**: `GET /candidate/{id}

**Response**
```json
{
    "candidate": {
        "candidateId": 1,
        "candidateName": "Reshma Salunkhe",
        "organisationName": "Hopscotch",
        "designation": "Software Engineer",
        "yearsOfExperience": 6.0
    },
    "message": "Candidate found"
}
```
### 3. Delete candidate API
**Endpoint**: delete /candidate/{id}

**Response**

```
Candidate deleted successfully with id : {id}
```

## Running the Application

**1. Clone the repository**

git clone https://github.com/Suyog-Salunkhe/docker-example-web-db-cache.git

**2. Navigate to the project directory:**

cd candidate-service

**3. Create Executable**

mvn clean package

**4.Run the Docker compose file**
```
cd ..
docker compose up -d
```
This will build and run the following services:

Candidate Service on port 8080

MySQL Database on port 3306

Redis on port 6379

**5. Stop all services**

To stop all running containers:
```
docker compose down
```

##  Logs and Monitoring

To view logs for each service, use the following commands:

Candidate Service Logs:
```
docker logs candidate-service-container
```
MySql Service Logs:
```
docker logs database-container
```
Redis Service Logs:
```
docker logs redis-container
```

## Database login and querying

To login and query database follow the steps given below:

```
docker exec -it database-container sh

mysql -h 127.0.0.1 -P 3306 -u root -p

Password :  root@456

use db-candidate-service;

select * from candidates;

```
## Redis cache monitoring

To check the in memory cache storage follow the steps given below:

```
docker exec -it redis-container redis-cli

keys *

GET candidates::1
```

## Cleaning Up
If you want to remove all containers and associated volumes:
```
docker-compose down --volumes
```



## License
[MIT](https://choosealicense.com/licenses/mit/)
