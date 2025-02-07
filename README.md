# Number Classification API
This task is an API that takes a number and returns interesting mathematical properties about it, along with a fun fact.

## Technology Stack
> - Java 21
> - Spring Boot
> - Maven

## Tools
> - IntelliJ IDEA
> - Postman
> - Git
> - GitHub
> - Heroku
> - Markdown

## Setup
1. Clone the repository.
```bash
git clone https://github.com/HNG-12/number-classification-api.git
```
2. Change directory to the project folder.
```bash
cd number-classification-api
```
3. Build the application.
```bash
mvn clean package
```
4. Run the application.
```bash
mvn spring-boot:run
```
5. Open Postman and test the API.
```http
GET http://localhost:8080/api/classify-number?number=599
```
5. Use cURL to test the API.
```bash
curl -X GET "http://localhost:8080/api/classify-number?number=599" -H "accept: application/json"
```

6. Run the tests.
```bash
mvn test
```

7. Run Test Coverage.
```bash
mvn clean test jacoco:report
```

## Project Structure
```bash
number-classification-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hng
│   │   │           └── numberclassificationapi
│   │   │               ├── NumberClassificationApiApplication.java
│   │   │               ├── controller
│   │   │               │   └── NumberClassificationController.java
│   │   │               ├── model
│   │   │               │   └── SuccessResponse.java
│   │   │               │   └── ErrorResponse.java
│   │   │               ├── service
│   │   │               │   └── NumberClassificationService.java
│   │   │               └── util
│   │   │                   └── NumberHelpers.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── hng
│       │           └── numberclassificationapi
│       │               ├── controller
│       │               │   └── NumberClassificationControllerTest.java
│       │               ├── service
│       │               │   └── NumberClassificationServiceTest.java
│       │               └── util
│       │                   └── NumberHelpersTest.java
```

## API Endpoint
```http
GET /api/classify-number?number={number}
```
- **Description:** This endpoint receives a number, classifies the number and returns interesting mathematical properties about it, along with a fun fact as a JSON object.

## Usage
- **Request Parameters:**
    - **number:** The number to be classified.
    - **Example:** `/api/classify-number?number=599`
- **Response:**
    - **Example:** 
    ```json
    {
  "number": 599,
  "is_prime": true,
  "is_perfect": false,
  "digit_sum": 23,
  "fun_fact": "599 is the smallest number whose digits add to 23.",
  "properties": ["odd"]
  }
  ```

- **Request Parameters:**
    - **number:** The number to be classified.
    - **Example:** `/api/classify-number?number=371
- **Response:**`
    - **Example:** 
    ```json
    {
  "number": 371,
  "is_prime": false,
  "is_perfect": false,
  "digit_sum": 11,
  "fun_fact": "371 is a narcissistic number.",
  "properties": ["armstrong", "odd"]
  }
  ```

- **Error Response:**
  - **Request Parameters:**
      - **number:** The invalid number to be classified.
      - **Example:** `/api/classify-number?number=abc
      - **Status Code:** 400
      - **Example:** 
      ```json
      {
    "number": "abc",
    "error": true
    }
    ```

## Live Application
The application is hosted on Heroku. Click [here](https://hng-stage-1-36877b5fe68d.herokuapp.com/api/classify-number?number=992) to test the API.

## Author
- [Aniebiet Afia](https://github.com/aniebietafia)
- [Twitter](https://twitter.com/aniebietafia_)
- [LinkedIn](https://www.linkedin.com/in/aniebietafia)