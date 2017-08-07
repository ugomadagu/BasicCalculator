package arithmetic;

import java.util.LinkedList;

public class Calculator {
  public String evaluate(String expression) {
    if(expression == null) {
      return null;
    }

    String[] operandTokens = expression.split("[^\\w\\.]+");
    String[] operatorTokens = expression.split("[\\w\\s\\.]+");

    LinkedList<Integer> operatorIndicesToProccess = new LinkedList<Integer>();

    for(int i = 0; i < operatorTokens.length; i++) {
      String operator = operatorTokens[i];
      if(operator.equals("*") || (operator.equals("/"))) {
        operatorIndicesToProccess.addFirst(i);
      } else if(operator.equals("+") || (operator.equals("-"))) {
        operatorIndicesToProccess.addLast(i);
      } else if(operator.equals("")) {
          // This if statement handles the first empty token that always appears in operatorTokens
      } else {
        throw new IllegalArgumentException("Bad operator provided.");
      }
    }

    for(int i : operatorIndicesToProccess) {
      int operandIndex = i - 1;
      int operatorIndex = i;

      String operator = operatorTokens[operatorIndex];
      String operand1 = operandTokens[operandIndex];
      String operand2 = operandTokens[++operandIndex];

      if(operand2 == null) {
        while(operandTokens[operandIndex] == null) {
          operandIndex++;
        }
        operand2 = operandTokens[operandIndex];
      }

      String result = doMath(operand1, operator, operand2);
      operandTokens[operatorIndex - 1] = null;
      operandTokens[operandIndex] = result;
    }

    return operandTokens[operandTokens.length - 1];
  }

  private String doMath(String operand1, String operator, String operand2) {
    double result = -1.0;
    double num1 = Double.parseDouble(operand1);
    double num2 = Double.parseDouble(operand2);
    if(operator.equals("*")) {
      result = num1 * num2;
    } else if(operator.equals("/")) {
      result = num1 / num2;
    } else if(operator.equals("+")) {
      result = num1 + num2;
    } else if(operator.equals("-")) {
      result = num1 - num2;
    }
    return Double.toString(result);
  }
}
