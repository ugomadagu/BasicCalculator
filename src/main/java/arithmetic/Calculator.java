package arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public String evaluate(String expression) {
    System.out.println(expression);
    if(expression == null) {
      return null;
    }

    if(expression.matches("\\d+")) {
      return expression;
    }

    String pattern = "([\\w\\.]+)\\s*([^\\w\\.\\s])\\s*([\\w\\.]+)\\s*(\\.*)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(expression);

    String result;

    if (m.find()) {
      String operand1 = m.group(1);
      String operator = m.group(2);
      String operand2 = m.group(3);
      String restOfExpression = m.group(4);

      System.out.println("operand1: " + operand1 + " | operator: " + operator + " | operand2: " + operand2 + " | restOfExpression:" + restOfExpression);

      if(operator.equals("+") || operator.equals("-")) {
        result = doMath(operand1, operator, evaluate(operand2 + restOfExpression));
      } else {
        String firstCalculation = doMath(operand1, operator, operand2);
        result = evaluate(firstCalculation + restOfExpression);
      }
    } else {
      throw new IllegalArgumentException("Bad expression.");
    }

    return result;


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
    } else {
      throw new IllegalArgumentException("Bad Operator.");
    }
    return Double.toString(result);
  }
}
