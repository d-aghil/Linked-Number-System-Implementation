# Linked-Number-System-Implementation


## Project Overview
The Linked Number System is a Java-based project designed to represent and manipulate large numbers using linked data structures. Unlike primitive data types, this system uses a custom linked list approach to handle numbers that exceed the capacity of standard integer types. The primary goal of this project is to demonstrate data structure implementation, exception handling, and object-oriented programming principles.

## Features
- Representation of large numbers using a doubly linked list.
- Basic arithmetic operations (addition, subtraction, etc.) on linked numbers.
- Error handling through custom exceptions.
- Modular design with separate classes for digits, linked nodes, and number operations.
- Comprehensive testing through a dedicated test class.

## Technologies Used
- Java: Core programming language.
- Object-Oriented Programming (OOP): Encapsulation, inheritance, and polymorphism.
- Exception Handling: Custom exceptions for robust error management.

## Project Structure
```
LinkedNumberSystem/
├── Digit.java                 # Represents a single digit in the linked number.
├── DLNode.java                # Defines the doubly linked list node structure.
├── LinkedNumber.java          # Handles operations and manipulations on linked numbers.
├── LinkedNumberException.java # Custom exception class for error handling.
├── TestLinkedNumber.java      # Contains test cases to validate system functionality.
└── README.md                  # Project documentation.
```

## File Descriptions
### 1. Digit.java
Defines the Digit class representing a single digit within the linked number structure. It ensures that only valid digits (0-9) are accepted and provides methods to retrieve and modify the digit.

### 2. DLNode.java
Implements the doubly linked list node, which forms the backbone of the linked number system. Each node holds a reference to a Digit object along with pointers to the previous and next nodes.

### 3. LinkedNumber.java
Manages the representation and manipulation of entire linked numbers. It includes methods for:
- Adding and removing digits.
- Performing arithmetic operations.
- Converting between linked numbers and standard numeric formats.
- Handling edge cases, such as leading zeros and negative numbers.

### 4. LinkedNumberException.java
Custom exception class used to handle errors specific to the linked number system, such as invalid digit input or improper operations.

### 5. TestLinkedNumber.java
A dedicated test class that validates the functionality of the linked number system. It includes:
- Unit tests for arithmetic operations.
- Edge case handling tests.
- Exception handling scenarios.

## Setup and Usage Instructions
### 1. Clone the Repository
```
git clone https://github.com/your-username/LinkedNumberSystem.git
cd LinkedNumberSystem
```

### 2. Compile the Java Files
```
javac *.java
```

### 3. Run the Test Cases
```
java TestLinkedNumber
```

### 4. Sample Output
```
Testing Linked Number Operations...
Addition Test Passed.
Subtraction Test Passed.
Exception Handling Test Passed.
All tests completed successfully.
```

## Why This Project?
- Demonstrates real-world application of linked data structures.
- Provides a solution for handling large numbers beyond standard data type limits.
- Enhances understanding of custom exception handling in Java.
- Serves as an educational tool for learning object-oriented programming and data structures.



