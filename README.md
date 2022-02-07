# Survey

Code Challenge Backend restaurant survey

## Use

- Java 11
- SpringBoot
- Gradle
- H2

## Install

### Initialize

run the following command

```bash
 docker-compose up -d
 ```

### Remove

run the following command

```bash 
docker-compose down -v --rmi all
```

## Getting Started paths

- Surveys path get http://localhost:8080/api/v1.0/surveys/{surveyId}
- Responses path post http://localhost:8080/api/v1.0/responses
- Postman collection https://www.getpostman.com/collections/b114288c9bc25096782a
- Swagger path http://localhost:8080/swagger-ui/
