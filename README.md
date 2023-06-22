# Animal Service - Coding Challenge - Paul Köpke

This project is my implementation of a Coding Challenge Animal Service for an fictional online game.
In the Coding Challenge, the goal is to develop an application
that generates a herd of animals with random animal group sizes.
I implemented this coding challenge using a Java Spring Boot backend application.

## The Challenge

For an only game, we need a new service which creates a herd of random distributed animal groups.
For example the service should be requested for a random herd with 167 animals in total.
An example distribution could be:

- 63 Giraffes
- 57 Elephants
- 47 Lions

### Boundaries

- Each group MUST be > 0
- The result MUST be different (non deterministic ) with each call . When the code gets called 100 times with the same
  parameters , there should be 100 different results
- Obvious biases in the result are strongly discouraged . An obvious bias would be if e.g. one group type always is the
  largest or smallest etc.)
- Downtime is the enemy. The service should be configurable and expendable without changing any code.

## Prerequisites

- Docker
- Docker Compose

## Setup

To start the application, the following commands must be executed in the root directory:

```
docker compose build
docker compose up
```

This will automatically build and launch the application in the container. In the same environment a PostgreSQL database
is also started.

## Usage

After launching the application, the public routes can be viewed, for example, via the Swagger UI interface to view and
operate them:

```
http://localhost:8080/swagger-ui/index.html
```

The application provides two routes:

### POST /animaltype

The 'animaltype' route accepts new AnimalTypes through a POST request. Example:

```json
{
  "name": "LION"
}
```

### GET /herd

This route is used to generate an herd, which distributes the number randomly to all created AnimalTypes.
For this purpose, the size of the herd to be generated is specified as a request parameter:

```
http://localhost:8080/herd?size=169
```

The return object is a JSON structure with the following structure:

```json
{
  "troops": [
    {
      "animalType": {
        "name": "LION"
      },
      "count": 39
    },
    {
      "animalType": {
        "name": "ELEPHANTS"
      },
      "count": 42
    }
  ]
}
```

The following command leads to the complete termination of the application:

```
docker compose down
```

## Testing

The application contains unit tests for every class. A test coverage report will be generated with the maven test
lifecycle phase and can be found under the following path:

```
./target/site/index.html
```
