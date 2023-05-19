# company-api-web-app
Spring-boot based project using java 11 and maven. It also uses h2 database for the persistence layer and exposes a REST API for fetching the company related data.

## Usage

First, make sure to build, test, package and copy the jar to the local repository, by running.
```bash
mvn clean install 
```
Next, run the spring-boot application, by executing:

```bash
mvn spring-boot:run
```
Once the application is run, in a separate terminal window (alternatively it can be done via an API client like [Postman](https://www.postman.com)), execute the following:
```bash
curl http://localhost:8080/api/employees
```
to get the full list of employees.

or execute:

```bash
curl http://localhost:8080/api/employees?dateOfBirth="<yyyy-MM-dd>"
```
to get the employees born on a specific date. Similarly, you can trigger the endpoint to filter the employees by departmentId.

>**Note**
>
>  Currently the setup is very simple and it is based on the in-memory setup of the h2 database and a initializing script (`data.sql`). The > datasource connection properties can be seen in the `application-properties` file. Also, the application currently doesn't have profiles and tests. They will follow gradually.
> The intention is to extract the repository logic to the `EmployeeService` class and afterwards to focus on creating the test > infrastructure that will support a test-driven development approach.
> Once the test harness is in place, the tests will drive the implementation of new CRUD endpoints, such as employee creation, update and removal, as well as more complex logic involving transactional support. With time, I will also add new capabilities, such as data stores/transport integration, external APIs, security features (authorization/authentication), monitoring and logging.
