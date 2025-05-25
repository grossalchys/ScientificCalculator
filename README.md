# Scientific Calculator using Java (OOP + JDBC + GUI)

This is a GUI-based Scientific Calculator developed in Java using Object-Oriented Programming (OOP), JDBC for MySQL connectivity, and Swing for the user interface. It supports operations with integers, floats, and complex numbers using **method overloading**.

---

## ✨ Features

- Arithmetic operations (`add`, `subtract`, `multiply`, `divide`)
- Trigonometric functions (`sin`, `cos`, `tan`)
- Logarithmic functions (`log`, `ln`)
- Support for **complex numbers**
- Method overloading with `int`, `float`, and `ComplexNumber`
- Stores all calculations in a **MySQL database**
- User-friendly GUI using **Java Swing**
- Displays calculation history

---

## 🛠️ Tech Stack

- Java (OOP Concepts)
- MySQL
- JDBC
- Swing GUI

---

## 🗃️ Database Setup

1. Create the database:
```sql
CREATE DATABASE scientific_calculator;
```

2. Use this schema for the operations table:
```sql
CREATE TABLE operations (
    operation_id INT AUTO_INCREMENT PRIMARY KEY,
    operand_type VARCHAR(20),
    operation VARCHAR(20),
    operand_1 VARCHAR(50),
    operand_2 VARCHAR(50),
    result VARCHAR(50),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

3. Update DB credentials in `DatabaseManager.java` and `OperationDAO.java`:
```java
private static final String USER = "root";
private static final String PASS = "your_password";
```

---

## ▶️ How to Run

### Compile:
```bash
javac -cp .;mysql-connector-java.jar src/com/calculator/*.java
```

### Run GUI:
```bash
java -cp .;mysql-connector-java.jar com.calculator.CalculatorUI
```

> On Linux/macOS replace `;` with `:` in classpath

---

## 📁 Project Structure

```
ScientificCalculator/
└── src/com/calculator/
    ├── Calculator.java
    ├── CalculatorUI.java
    ├── ComplexNumber.java
    ├── DatabaseManager.java
    ├── Operation.java
    ├── OperationDAO.java
    └── Main.java

---

## 🧑‍💻 Authors

- Aadarsh Singh 24SCSE1010361
- Adarsh 24SCSE1010393

