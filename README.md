# Software Engineer Test Assignment

## My Learning 

Before the project implementation, I had small experience of building REST API's using Maven and Tomcat (manually), but I didn't had any experience in Spring Boot, RabbitMQ, PostGreSQL, Gradle, MyBatis, JUnit. However, I took this opportunity as a challenge for me, and I managed to create at least some part of the big project. Even thought I had 2 weeks for project building, it felt like i had only couple of days due to the fact that it was all new for me and I also had studies during this period. Because of this, project is not done fully yet, it's still has couple of things to do.

### Resources Used

Here listed some sources that helped me to understand the Spring Boot and others technologies. It's not a full list, it was more, but unfortunatelly it is not possible to find them all.

Spring Boot Basics - https://spring.io/guides/gs/spring-boot/ <br>
MyBatis and Spring Boot - https://medium.com/@cibofdevs/complete-guide-to-crud-using-mybatis-and-spring-boot-d6c165167cdd <br>
RabbitMQ Integration - https://spring.io/guides/gs/messaging-rabbitmq <br>
Docker Compose - https://spring.io/guides/gs/spring-boot-docker <br>

## How to Build and Run

For running you need Docker and Docker Compose installed

By this URL you can get access to API: http://localhost:8080

##  API Documentation

### Create Account

**POST** `/api/accounts`

Request:
```json
{
  "customerId": 12345,
  "country": "Estonia",
  "currencies": ["EUR", "SEK"]
}
```

Response (201 Created):
```json
{
  "accountId": 1,
  "customerId": 12345,
  "balances": [
    {"availableAmount": 0, "currency": "EUR"},
    {"availableAmount": 0, "currency": "SEK"}
  ]
}
```

### Get Account

**GET** `/api/accounts/{accountId}`

Response (200 OK):
```json
{
  "accountId": 1,
  "customerId": 12345,
  "balances": [
    {"availableAmount": 150.50, "currency": "EUR"},
    {"availableAmount": 0, "currency": "SEK"}
  ]
}
```

### Create Transaction

**POST** `/api/transactions`

Request:
```json
{
  "accountId": 1,
  "amount": 100.78,
  "currency": "EUR",
  "direction": "IN",
  "description": "Payment"
}
```

Response (201 Created):
```json
{
  "accountId": 1,
  "transactionId": 1,
  "amount": 100.78,
  "currency": "EUR",
  "direction": "IN",
  "description": "Payment",
  "balanceAfterTransaction": 100.78
}
```

### Get Transactions

**GET** `/api/transactions/{accountId}`

Response (200 OK):
```json
[
  {
    "accountId": 1,
    "transactionId": 1,
    "amount": 100.78,
    "currency": "EUR",
    "direction": "IN",
    "description": "Payment",
    "balanceAfterTransaction": 100.78
  }
]
```

## Important Choices

### Service Layer Pattern

**Why?**
- Separates logic from controllers
- Makes unit testing easier
- Usual SpringBoot practice


### DTO Pattern

**Why?**
- Separates API contracts from internal models
- Allows changes to internal model without breaking API
- Better control over what data is exposed
- Seen a lot of tutorials where DTO's were used

### BigDecimal for Money

**Why?**
- `double` and `float` have precision issues with currency
- `BigDecimal` provides exact decimal arithmetic

### Enum Validation

**Why?**
- Checks that values are correct
- `Currency` and `TransactionDirection` enums ensure type safety
- Easy to validate

## AI Usage
In order to challenge myself and ensure, that i'm actually learning something, project was done by me.
However, some practice before project starting to fully understand SpringBoot was done with AI: It could generate some code examples for my own practice, make an test exercises for me and trying to find some sources for learning.
Also were attempts for problem solving, but they were done after long time searching on stackoverflow and similar websites. However, AI did not help me in that way.

## Conclusion
I understand that project is not done fully, and contains critical errors, but I did this work with great effort and motivation, it was interesting experience for me. In the future, I also plan to continue developing myself and delivering the best results. <br>
Thank you for considering me as a candidate. I look forward to hearing the results of my assessment.