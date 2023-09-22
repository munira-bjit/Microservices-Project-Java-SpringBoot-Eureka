# Microservices Project - Java, Spring Boot, and Eureka

## Overview

This project is a microservices-based application developed using Java and the Spring Boot framework. 
It leverages Spring Cloud components like Eureka for service registration and discovery, along with an in-memory database for data storage.

## Tech Stack

- **Languages:** Java
- **Frameworks:** Spring Boot, Spring Cloud (Eureka, Gateway)
- **Service Registry:** Eureka
- **Database:** In-memory
- **Connecting Services:** HttpExchange

## Features

### API Gateway (api-gateway)

- Routes incoming requests to microservices based on the request path.
- Routes requests to the following microservices:
  - `employee-service`
  - `department-service`
  - `course-service`

### Employee Service (employee-service)

- Manages employee data.
- Provides a RESTful API for:
  - Adding new employees.
  - Retrieving employee information.
  - Finding employees by department.

### Department Service (department-service)

- Manages department data.
- Provides a RESTful API for:
  - Adding new departments.
  - Retrieving department information.
  - Finding departments.
- Integrates with `employee-service` to retrieve employees within departments.
- Integrates with `course-service` to retrieve courses within departments.

### Course Service (course-service)

- Manages course data.
- Provides a RESTful API for:
  - Adding new courses.
  - Retrieving course information.
  - Finding courses.
- Allows filtering courses by department.

### Service Registry (service-registry)

- Eureka server for service registration and discovery.
- Microservices register themselves with Eureka for easy discovery by other services.
