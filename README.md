# 💇‍♀️ Salon Appointment Booking System 

## Overview  
A modern, scalable salon appointment booking system builting using **Microservices Architecture**. The project includes backend microservices built with **Spring Boot**, secure authentication via **Keycloak** and **JWT**, event-driven communication with **RabbitMQ**, and real-time updates using **WebSocket**. The frontend is created with **React**, styled with **TailwindCSS** and **Material-UI**, using **Redux** for state management and **Formik** for form handling. Payments are integrated via **Razorpay**.

## Using Technologies  

### Microservices  
- Independent, scalable services communicating via REST APIs and messaging queues.

### Backend  
- **Spring Boot** for RESTful services.  
- **Keycloak** for authentication and authorization.  
- **JWT** token-based security.  
- **MySQL** as the relational database.  
- **RabbitMQ** for event-driven communication.  
- **WebSocket** for real-time notifications.

### DevOps  
- **Docker** for containerization and deployment.

### Frontend  
- **React** for building interactive user interfaces.  
- **TailwindCSS** for utility-first CSS styling.  
- **Redux** for efficient state management.  

---

## 📦 Services Overview  

- **User Service:** User registration, login, and profile management.  
- **Salon Service:** Salon creation, updating, searching, and owner-specific retrieval.  
- **Category Service:** Manage salon categories with owner and user endpoints.  
- **Service Offering:** Manage salon services, filterable by category.  
- **Booking Service:** Book appointments, payment link generation, booking status updates, reports.  


