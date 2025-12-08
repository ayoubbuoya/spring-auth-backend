# Spring Boot Authentication Backend

## 📖 About This Project

This is a learning project where I practice backend development using **Spring Boot**, focusing on implementing **authentication and authorization** following industry best practices. As a developer wanting to learn Spring Boot, I decided to create this project to learn by doing – building a real-world authentication system from scratch.

## 🎯 Project Goals

- Learn Spring Boot framework fundamentals
- Implement secure authentication mechanisms
- Follow backend development best practices
- Make JWT token management using Spring Boot
- Practice secure cookie handling
- Build a production-ready authentication system

## 🔐 Authentication Architecture

This project implements a modern, secure authentication system with the following features:

### Token Strategy

- **Access Token**: Sent in the response body (short-lived)
- **Refresh Token**: Stored in HTTP-only cookies (long-lived, more secure)

This approach provides a balance between security and usability:

- Access tokens are used for API authentication
- Refresh tokens are protected from XSS attacks via HTTP-only cookies
- Automatic token refresh mechanism for seamless user experience

### Security Features

- Password encryption using BCrypt
- JWT-based authentication
- HTTP-only cookies for refresh tokens
- CSRF protection considerations
- Secure session management

## 🛠️ Technologies Used

- **Java** - Programming language
- **Spring Boot** - Backend framework
- **Spring Security** - Authentication and authorization
- **JWT (JSON Web Tokens)** - Token-based authentication
- **Maven** - Dependency management
- **PostgreSQL** - Database

## 🚀 Getting Started

### Prerequisites

- Java 25
- Maven 3.6+
- Your preferred IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation

1. Clone the repository

```bash
git clone https://github.com/ayoubbuoya/spring-auth-backend.git
cd spring-auth-backend
```

2. Configure your database in `application.properties` or `application.yml`

3. Build the project

```bash
./mvnw clean install
```

4. Run the application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080/swagger-ui.html`

## 📚 API Endpoints

### Authentication

- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login and receive access token
- `POST /api/auth/refresh` - Refresh access token using refresh token cookie
- `POST /api/auth/logout` - Logout and invalidate tokens

### Protected Routes

- `GET /api/user/profile` - Get user profile (requires authentication)

## 🔑 Best Practices Implemented

- ✅ Separation of concerns (Controller, Service, Repository layers)
- ✅ DTO (Data Transfer Objects) pattern
- ✅ Exception handling with custom exceptions
- ✅ Input validation
- ✅ Secure password storage
- ✅ Token expiration and refresh mechanism
- ✅ HTTP-only cookies for sensitive tokens
- ✅ Environment-based configuration
- ✅ Clean code principles

## 📖 What I Learned

Through building this project, I gained hands-on experience with:

- Spring Boot application architecture
- Spring Security configuration
- JWT token generation and validation
- Cookie management and security
- RESTful API design
- Database integration with Spring Data JPA
- Exception handling in Spring Boot
- Maven project structure and dependency management

## 🤝 Contributing

This is a personal learning project, but suggestions and feedback are always welcome! Feel free to open an issue or submit a pull request.

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Ayoub Buoya**

- GitHub: [@ayoubbuoya](https://github.com/ayoubbuoya)

---

_This project is part of my journey to master Spring Boot and backend development. Happy coding! 🚀_
