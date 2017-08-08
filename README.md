### Overview
This is my implimentation of a basic calculator. The implimentation on the master branch is recursive.

### Build
```./gradlew build```

### Run tests
```./gradlew test```   

### Manually interact with the application via command line
After building, run ```java -cp build/classes/java/main arithmetic.CliMain``` from the top-level BasicCalculator directory to start the application. Then, you can enter arithmetic expressions and receive the answers in the console. To exit the program, type ```exit``` into the console.

### Assumptions

1. Since the problem statement made no mention of it, I assumed that expressions would not have parentheses. For example, I assumed that my code would not be asked to calculate an expression like **2 * (3 + 4)**
