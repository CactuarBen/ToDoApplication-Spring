# ToDoApplication-Spring
The same ToDoApplication recreated in Spring boot

The goal of this application is to recreate the recently created ToDoApplication with Spring boot.
The used dependencies for the first phase are:
1) **Spring Web** - provides Spring MVC for building REST API endpoints. Enables `@RestController`, `@RequestMapping`, `@GetMapping` etc. Includes Tomcat server to run the application.
2) **Spring Boot Dev Tools** - Enables automatic restarts when code changes, disables cachiong for templates.
3) **Spring Data JPA** - Simplifies database operations, allows to use JavaPersistanceAPI instead of raw SQL. Provides JpaRepository, which eliminates need for queries. Removes the need to write manual queries.
4) **H2 Database** - Provides in-memory database for developing and testing. Resets data every time the app restarts, allows easy SQL debugging via H2 console. Will help with moving to MySQL/PostgreSQL.

The used dependency for the second phase is: Input Validation
- **Validation** - prevents empty or invalid input when adding or updating tasks. Ensures fields like taskName cannot be blank.

The used dependency for the third phase is: API documentation with Swagger IU
- **OpenAPI starter WebMVC** - Provides a user-friendly API interface, replaces Postman for testing.

The used dependency for the fourth phase is: Secure API with basic authentication
- **Security** - Prevents unauthorized access to sensitive operations.

The used dependency for the fifth phase is: Switching from H2 to PostgreSQL
- **PostgreSQL driver** - To make the data be stored permanently.

The used dependency for the sixth phase is: Implement JWT Authentication for Token-Based Security 
- **JWT-based authentication** - More secure than Basic Auth, uses tokens to log in users once.
