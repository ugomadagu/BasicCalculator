package arithmetic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public double evaluate(String expression) throws Exception {
    if(expression == null || expression.equals("") || expression.matches("\\s+")) {
      throw new IllegalArgumentException("Expression must have at least two operands and one operator.");
    }

    if(expression.matches("(\\-*\\d+(\\.\\d+)*)")) {
      return Double.parseDouble(expression);
    }

    String pattern = "([\\w\\.\\-*]+)\\s*([^\\w\\.\\s])\\s*([\\w\\.\\-*]+)\\s*(.*)";
    Pattern r = Pattern.compile(pattern);
    Matcher m = r.matcher(expression);

    double result;

    if (m.find()) {
      double operand1 = Double.parseDouble(m.group(1));
      String operator = m.group(2);
      double operand2 = Double.parseDouble(m.group(3));
      String restOfExpression = m.group(4);

      if(operator.equals("+")) {
        result = doMath(operand1, "+", evaluate(operand2 + restOfExpression));
      } else if(operator.equals("-")) {
        operand2 = operand2 * -1.0;
        result = doMath(operand1, "+", evaluate(operand2 + restOfExpression));
      } else {
        double firstCalculation = doMath(operand1, operator, operand2);
        result = evaluate(firstCalculation + restOfExpression);
      }
    } else {
      throw new IllegalArgumentException("Bad expression.");
    }

    return result;
  }

  private double doMath(double operand1, String operator, double operand2) {
    double result = -1.0;
    if(operator.equals("*")) {
      result = operand1 * operand2;
    } else if(operator.equals("/")) {
      result = operand1 / operand2;
    } else if(operator.equals("+")) {
      result = operand1 + operand2;
    } else if(operator.equals("-")) {
      result = operand1 - operand2;
    } else {
      throw new IllegalArgumentException("Bad Operator.");
    }
    return result;
  }
}
