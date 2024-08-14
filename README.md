# Boundary Value Analysis and Equivalence Partitioning Tests

## Overview

This project demonstrates how to implement Boundary Value Analysis (BVA) and Equivalence Partitioning (EP) testing techniques using Java, JUnit 5, and REST Assured. The project is structured to follow SOLID principles, ensuring clean, maintainable, and extendable code.

Additionally, the project has been Dockerized to ensure a consistent and reproducible environment for running tests, regardless of the local development setup.

## Project Structure
```
📦 
├─ Dockerfile
├─ README.md
├─ pom.xml
└─ src
   ├─ main
   │  └─ java
   │     └─ com
   │        └─ basit
   │           └─ HttpServer.java
   └─ test
      └─ java
         └─ demo
            ├─ Data
            │  ├─ BoundaryValue
            │  │  ├─ HigherBoundaryData.java
            │  │  └─ LowerBoundaryData.java
            │  ├─ DataProvider.java
            │  └─ Partitions
            │     └─ PartitionsData.java
            ├─ Models
            │  └─ QueryParamData.java
            ├─ Tests
            │  ├─ BoundaryValueAnalysisTest.java
            │  └─ EquivalencePartitioningTest.java
            └─ Validations
               └─ Validations.java
```
### Packages

- **Data**: Contains classes that provide test data for BVA and EP.
  - **BoundaryValue**: Provides data for boundary value tests.
  - **Partitions**: Provides data for equivalence partitioning tests.
- **Models**: Contains the QueryParamData class used to represent query parameter data.
- **Tests**: Contains the test classes for BVA and EP.
- **Validations**: Contains the ValidationService class that encapsulates the validation logic.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Docker

### Setup

1. Clone the repository:
   
   ```
   git clone https://github.com/yourusername/boundary-value-analysis-tests.git
   cd boundary-value-analysis-tests
   ```

2. Install dependencies:
   ```
   mvn clean install
   ```
   
## Running the Tests
To run the tests, execute the following command:
	
    mvn test

## Dockerizing the Project
The project has been Dockerized to ensure consistency across different environments. Below are the steps to build and run the Docker container.

Building the Docker Image
To build the Docker image for the project, use the following command:

    docker build -t bva/eq-tests .

# Running the Docker Container
Once the Docker image is built, you can run the tests inside the container and serve the test reports via an HTTP server.

 	
    docker run -p 8080:8080 bva/eq-tests

This command will:

1. Run the tests using Maven.
2. Generate the test report.
3. Start an HTTP server to serve the report on http://localhost:8080/.
4. Accessing the Test Reports
5. After running the container, you can access the test reports by navigating to http://localhost:8080/ in your web browser.

# Handling Test Failures
If any test fails, the report will still be generated and served, allowing you to review the failures. The Docker container is set up to handle both successful and failed test runs.


## Contributing
1. Fork the repository.
2. Create your feature branch (git checkout -b feature/your-feature).
3. Commit your changes (git commit -am 'Add your feature').
4. Push to the branch (git push origin feature/your-feature).
5. Create a new Pull Request.

## License
	This project is licensed under the MIT License - see the LICENSE file for details.
