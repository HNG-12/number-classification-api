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
3. Run the application.
```bash
mvn spring-boot:run
```
4. Open Postman and test the API.
```http
GET http://localhost:8080/api/classify-number?number=599
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
│   │   │               │   └── NumberClassification.java
│   │   │               ├── model
│   │   │               │   └── NumberResponse.java
│   |   |               |   └── ErrorResponse.java
│   │   │               ├── service
│   │   │               │   └── NumberClassificationService.java
│   │   │               └── util
│   │   │                   └── NumberClassificationUtil.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── hng
│       │           └── numberclassificationapi
│       │               ├── controller
│       │               │   └── NumberClassificationControllerTest.java
│       │               ├── model
│       │               │   └── NumberClassificationTest.java
│       │               ├── service
│       │               │   └── NumberClassificationServiceTest.java
│       │               └── util
│       │                   └── NumberClassificationUtilTest.java

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