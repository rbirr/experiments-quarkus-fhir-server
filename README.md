# fhir-server-quarkus

This project implements a fhir server on quarkus. It uses the hapi library and registers a ResfulServer 
servlet which contains the functionality of the hapi server.

The server contains a single resource provider of type `Patient`. The patient data is loaded from a backend rest api.
The backend is mocked with [Mockoon](https://mockoon.com/) and can be started via the [mockoon docker container](https://hub.docker.com/r/mockoon/cli). 

## Mockoon
To run the mock server in a docker container, run the following command:

```shell script
docker run -d --mount type=bind,source=.\mockoon\backend.json,target=/data,readonly -p 3000:3000 mockoon/cli:latest --data data --port 3000
```

To test the mock, run http://localhost:3000/Patient/pat1. You should receive a fhir patient resource.

Valid id's for the patient are {pat1, pat2}, every other id returns a 404 error.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

### Testing the application
Open the following url: 

http://localhost:8080/fhir/Patient/pat1?_format=json

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using a docker multistage build:

```shell script
docker build --no-cache -f src/main/docker/Dockerfile.multistage -t fhir-server-quarkus-native .
```
ATTENTION: The native build does not work yet. The container is built, the service will start but it will
throw an exception because of a missing dependency.
