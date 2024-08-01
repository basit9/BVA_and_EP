# Boundary Value Analysis and Equivalence Partitioning Tests

## Overview

This project demonstrates how to implement Boundary Value Analysis (BVA) and Equivalence Partitioning (EP) testing techniques using Java, JUnit 5, and REST Assured. The project is structured to follow SOLID principles, ensuring clean, maintainable, and extendable code.

## Project Structure
```
📦 
├─ pom.xml
└─ src
   ├─ main
   │  └─ java
   │     └─ com
   │        └─ basit
   │           └─ Main.java
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
            │  ├─ BoundaryValueAnalysisTests.java
            │  └─ EquivalencePartitioningTests.java
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
	
 ```
		mvn test
```
## Contributing
1. Fork the repository.
2. Create your feature branch (git checkout -b feature/your-feature).
3. Commit your changes (git commit -am 'Add your feature').
4. Push to the branch (git push origin feature/your-feature).
5. Create a new Pull Request.

## License
	This project is licensed under the MIT License - see the LICENSE file for details.
