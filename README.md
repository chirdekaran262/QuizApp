# QuizApp Backend

This repository contains the backend implementation for the **QuizApp** built using Spring Boot. The backend provides RESTful APIs for managing quizzes, questions, and quiz results. It uses PostgreSQL as the database.

---

## Features

- **Question Management**: Add, retrieve, and manage questions.
- **Quiz Management**: Create quizzes, fetch quiz questions, and submit answers.
- **Category-based Filtering**: Fetch questions by category.
- **Result Calculation**: Calculate quiz results based on user responses.

---

## Tech Stack

- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Dependency Injection**: Spring Framework

---

## Prerequisites

- Java 17 or higher
- Maven 3.8+
- PostgreSQL database

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/quizapp-backend.git
cd quizapp-backend
```

### 2. Set Up the Database
1. Install PostgreSQL.
2. Create a new database (e.g., `quizapp`).
3. Update the `application.properties` file with your PostgreSQL credentials.

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/quizapp
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and Run the Application

Use Maven to build and run the application.

```bash
mvn clean install
mvn spring-boot:run
```

The server will start on `http://localhost:8080`.

---

## API Endpoints

### Question Management
- **GET /questions/getQuestions**  
  Retrieves all questions.  
  **Response**: List of all questions.

- **GET /questions/category/{category}**  
  Retrieves questions by category.  
  **Path Variable**: `category` (String)  
  **Response**: List of questions matching the category.

- **POST /questions/addQuestions**  
  Adds multiple questions at once.  
  **Request Body**: List of `Question` objects.  
  **Response**: Success message.

- **POST /questions/addQuestion**  
  Adds a single question.  
  **Request Body**: `Question` object.  
  **Response**: Success message.

---

### Quiz Management
- **POST /quiz/create**  
  Creates a quiz with specified parameters.  
  **Request Params**:  
    - `category` (String): Quiz category.  
    - `numQ` (int): Number of questions.  
    - `title` (String): Title of the quiz.  
  **Response**: Success message.

- **GET /quiz/get/{id}**  
  Retrieves questions for a specific quiz by quiz ID.  
  **Path Variable**: `id` (int)  
  **Response**: List of `QuestionWrapper` objects.

- **POST /quiz/submit/{id}**  
  Submits a quiz and calculates the result.  
  **Path Variable**: `id` (int)  
  **Request Body**: List of `Response` objects (user answers).  
  **Response**: Total score (integer).

---

## Directory Structure

```plaintext
quizapp-backend/
├── src/main/java/com/karan/QuizApp
│   ├── controller        # REST API Controllers
│   ├── model             # Entity Classes and Wrapper Objects
│   ├── repository        # Data Access Layer
│   ├── service           # Business Logic Layer
│   ├── QuizAppApplication.java
├── src/main/resources
│   ├── application.properties  # Configuration File
├── pom.xml                     # Maven Build File
```

---

## Contribution Guidelines

1. Fork the repository.
2. Create a new branch (`feature/new-feature` or `bugfix/issue-id`).
3. Commit changes and push to your branch.
4. Submit a pull request for review.

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contact

For any inquiries or support, reach out to:
- **Name**: Karan Prabhakar Chirde
- **Email**: chirdekaran262@gmail.com
- **GitHub**: [Your GitHub Profile](https://github.com/chirdekaran262)

---

Happy Coding! 🎉
