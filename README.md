# Quiz Application - Backend

A Spring Boot REST API for a quiz application with multiple-choice questions, supporting frontend integration and detailed quiz results.

-----

## Tech Stack

  * **Java 17**
  * **Spring Boot 3.5.6**
  * **Spring Data JPA**
  * **H2 Database** (in-memory)
  * **Maven**

-----

## Features

  * Fetch quiz questions **without revealing correct answers**
  * Submit quiz answers and get **detailed results**
  * **Automatic score calculation**
  * **Pre-loaded sample questions**
  * **CORS enabled** for frontend integration

-----

## Prerequisites

  * **Java 17** or higher
  * **Maven 3.6+** (or use included Maven wrapper)

-----

## Project Structure

src/main/java/com/quiz/

├── controller/ # REST controllers
├── dto/ # Data transfer objects
├── entity/ # JPA entities
├── repository/ # Data access layer
└── service/ # Business logic

-----

## Steps to Run

1.  **Download/Clone the Project**
      * `git clone <your-repo-url>`
      * `cd Quiz`
2.  **Navigate to Project Root**
      * Ensure the folder contains:
          * `pom.xml`
          * `mvnw` and `mvnw.cmd`
          * `src/` folder
3.  **Run the Application**
      * Linux/Mac: `./mvnw spring-boot:run`
      * Windows (Command Prompt): `mvnw.cmd spring-boot:run`
      * Windows (PowerShell): `.\mvnw.cmd spring-boot:run`
4.  **Wait for Startup**
      * Look for: `Started QuizApplication in X.XXX seconds`
5.  **Application is Ready**
      * Backend running at: `http://localhost:8080`
      * H2 Console: `http://localhost:8080/h2-console`
      * Test endpoint: `http://localhost:8080/api/quiz/questions`

-----

## First Time Running

  * **Maven wrapper downloads Maven automatically** (one-time, $\sim$10MB)
  * Downloads all dependencies (Spring Boot, H2, etc.)
  * Takes a few minutes depending on internet speed

Subsequent runs are faster with no downloads needed.

-----

## How It Works

  * Maven wrapper checks for Maven and downloads if missing
  * Reads `pom.xml` for dependencies
  * Downloads dependencies (first time only)
  * Compiles Java files in `src/main/java/`
  * Runs `import.sql` to load **10 questions** into H2 database
  * Starts **Tomcat server on port 8080**
  * Application becomes ready

-----

## API Endpoints

### Get Quiz Questions

  * `GET /api/quiz/questions`
  * Returns all questions with options (without correct answers)

**Sample Response**

```json
[
  {
    "id": 1,
    "questionText": "Which is the longest river in the world?",
    "options": {
      "A": "Nile",
      "B": "Amazon",
      "C": "Yangtze",
      "D": "Ganga"
    }
  }
]
```

-----

### Submit Quiz

  * `POST /api/quiz/submit`
  * `Content-Type: application/json`

**Request Body**

```json
{
  "answers": {
    "1": "A",
    "2": "B",
    "3": "C"
  }
}
```

**Response**

```json
{
  "totalQuestions": 10,
  "correctAnswers": 7,
  "score": 70.0,
  "results": [
    {
      "questionId": 1,
      "questionText": "Which is the longest river in the world?",
      "userAnswer": "A",
      "correctAnswer": "A",
      "isCorrect": true
    }
  ]
}
```

-----

## Database

  * **H2 in-memory database** with 10 pre-loaded questions
  * Questions inserted automatically via `import.sql`

### H2 Console

  * URL: `http://localhost:8080/h2-console`
  * JDBC URL: `jdbc:h2:mem:quizdb`
  * Username: `sa`
  * Password: (leave empty)

-----

## Configuration

`src/main/resources/application.properties`

```ini
server.port=8080
spring.datasource.url=jdbc:h2:mem:quizdb
spring.jpa.hibernate.ddl-auto=create
spring.h2.console.enabled=true
```

-----

## CORS Configuration

Enabled for:

  * `http://localhost:3000` (React default)
  * `http://localhost:5173` (Vite default)

Modify `QuizController` to add more origins if needed.

-----

## Troubleshooting

  * **Port 8080 already in use**: Change `server.port` in `application.properties`
  * **JAVA\_HOME not set**: Set environment variable or ensure `java` works in terminal
  * **Permission denied (Linux/Mac)**: `chmod +x mvnw`

-----

## IDE Usage

  * No IDE required; can run from terminal
  * Recommended IDEs: **IntelliJ IDEA**, **VS Code** (Java extensions), **Eclipse**
  * Opening the project folder will automatically recognize it as a **Maven project**

-----

## Summary

1.  Install **Java 17+**
2.  Open terminal in project folder (where `pom.xml` is)
3.  Run: Linux/Mac `./mvnw spring-boot:run` or Windows `mvnw.cmd spring-boot:run`
4.  Wait for `Started QuizApplication`
5.  Access backend at `http://localhost:8080`