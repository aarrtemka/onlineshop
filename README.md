# Product Store API

Welcome to the Book Store API! This endeavor was ignited by the quest for a dynamic and effective solution to revolutionize the book store industry. Whether you're stewarding a brick-and-mortar haven for book lovers or curating an online literary emporium, our API is your steadfast companion, equipped to empower you with the tools essential for effortlessly managing your book inventory, organizing customer data, and orchestrating sales transactions with unmatched finesse.
### Watch a [video](https://www.loom.com/share/6e47d021bfb043ebaa6a13b781f8a68d?sid=18eed066-3796-4b50-87f0-09795b6ff540) about this project
## Table of Contents

- [Technologies and Tools Used](#technologies-and-tools-used)
- [Controller Functionalities](#controller-functionalities)
- [Installation and Usage](#installation-and-usage)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Postman Collection](#postman-collection)
- [Challenges Faced](#challenges-and-solutions)
- [Conclusion](#conclusion)

## Technologies and Tools Used

This API is built using modern technologies and tools to ensure reliability, security, and performance:

- **Spring Boot**: We've leveraged the power of Spring Boot to create a highly scalable and easy-to-maintain application.
- **Hibernate**: Hibernate, an Object-Relational Mapping (ORM) framework, streamlines database interaction by mapping Java objects to database tables, making it feel like second nature.
- **Spring Security**: Security is a top priority. We've implemented Spring Security to protect your data and ensure only authorized access.
- **JWT (JSON Web Tokens)**: Fortify our application with JWT-based authentication and authorization, as if you're locking it down with a secure shield.
- **Spring Data JPA**: With Spring Data JPA, managing our book data in the database is a breeze.
- **MapStruct**: MapStruct simplifies the transformation between different data models.
- **Liquibase**: Effortlessly manage database schema changes with Liquibase, making it seem like a walk in the park.
- **Swagger**: Explore and interact with our API easily through the Swagger documentation.
- **Docker**: Containerization for easy deployment and scalability.
- **Postman**: I've provided a collection of Postman requests to help you test and use the API effectively.

## Controller Functionalities

### Our API consists of several controllers, each serving a specific purpose:

- **AuthenticationController**: Handles user authentication and registration.

- **BookController**: Handles book-related operations, including creation, retrieval, update, and deletion of products.

- **CategoryController**: Manages categories, enabling admins to create, update, delete categories, and retrieve products by category.

- **ShoppingCartController**: Manages shopping cart information, allowing users to create, retrieve, update, and delete cart items.

- **OrderController**: Handles order management, including creating orders, updating order status, and retrieving order history.

# Installation and Usage

You can interact with the Book Store API in two ways:

1. **Using Swagger (No Installation Required)**

   To test the API without any installation, you can utilize Swagger, which provides a user-friendly interface for interacting with your API.

    - Open your web browser and navigate to [Swagger UI](http://ec2-13-51-233-107.eu-north-1.compute.amazonaws.com/api/swagger-ui/index.html#/).
    - Explore and test the various API endpoints directly through the Swagger interface.

**Authentication for Swagger UI:**

- **Admin Access**: If you want to access admin-specific functionalities, use these credentials:
    - **Username**: admin@a.ua
    - **Password**: qwerty123

2. **Local Installation**

   If you prefer to run the Book Store API on your local machine, follow these steps:

   ### Prerequisites

   Before you begin, ensure you have the following prerequisites installed on your system:

    - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
    - [MySQL database](https://www.mysql.com/downloads/)
    - [Docker](https://docs.docker.com/get-docker/) (Optional)

   ### Installation with Docker

   Follow these steps to set up and run the Book Store API on your local machine:

    1. **Clone the Repository:**

       ```shell
       git clone https://github.com/Zel1oy/online-book-store.git
       cd online-book-store
       ```

    2. **Build with Maven:**

       ```shell
       mvn clean install
       ```

    3. **Docker Image Creation:**

       ```shell
       docker build -t your-image-name .
       ```

    4. **Docker Compose:**

       ```shell
       docker-compose build
       docker-compose up
       ```

   Make sure you have Docker and Docker Compose installed and properly configured on your machine before running the last two commands.

    ### Installation without Docker

    Follow these steps to set up and run the Book Store API on your local machine:

    1. **Clone the Repository:**

       ```shell
       git clone https://github.com/Zel1oy/online-book-store.git
       cd online-book-store
       ```

    2. **Build with Maven:**

       ```shell
       mvn clean install
       ```

    3. **Comment docker compose dependency:**

        You should comment 38-41 lines of pom.xml code and reload all maven projects. The dependency should look like this below:
        ```
       <!--<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
        </dependency>-->
       ```

    4. **Configure a DB on your local machine:**
        
        You should create *book_store* schema and edit username and password in *application.properties* according to your credentials


   **You've now successfully set up and launched the Book Store API locally.**

## Postman Collection
For your convenience, I've created a Postman collection that includes sample requests for various API endpoints. You can download it [here](productstore-api.postman_collection.json) and import it into your Postman workspace to get started quickly.

## Challenges and Solutions

Building the Online Book Store project was a fulfilling endeavor, marked by various challenges. In this article, we'll briefly explore the hurdles we encountered during development and how we addressed them to create a robust e-commerce platform.

### Challenge 1: Data Modeling and build different views from our domain models

**Issue:** Designing a flexible data model for products, users, orders, and categories was complex and showing user only necessary data.

**Solution:** We used Spring Data JPA and Liquibase to create an adaptable schema and pattern Dto.

### Challenge 2: Security

**Issue:** Ensuring data security and user authentication was paramount.

**Solution:** Spring Security and JWT tokens were implemented for robust protection.

### Challenge 3: Exception Handling

**Issue:** Handling errors and exceptions systematically was crucial.

**Solution:** We developed a global handler and custom exceptions for better error reporting.
## Contributing

If you'd like to contribute to this project, I always ready for conversation
on [GitHub](https://github.com/Zel1oy)

## Conclusion
The productstore API provides a solid foundation for building a book-selling platform. Whether you're starting a new online productstore or enhancing an existing one, this API can help you manage products, orders, and customers efficiently. Feel free to reach out if you have any questions or need assistance.

Thank you for your interest in Book Store API!
