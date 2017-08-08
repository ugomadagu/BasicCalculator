package arithmetic;

import org.junit.Test;
import static org.junit.Assert.*;
import arithmetic.*;

public class Tests{
  Calculator calc = new Calculator();

  @Test
  public void BasicAddition() {
    String expression = "2 + 4";
    double expectedAnswer = 6.0;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void BasicSubtraction() {
    String expression = "2 - 4";
    double expectedAnswer = -2.0;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void BasicMultiplication() {
    String expression = "2 * 4";
    double expectedAnswer = 8.0;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void BasicDivision() {
    String expression = "2 / 4";
    double expectedAnswer = 0.5;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void OrderOfOperationsTest() {
    String expression = "2 + 4 - 6 * 3 + 8";
    double expectedAnswer = -4.0;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void DoubleNegativeTest() {
    String expression = "2 - -4 - 6 * 3 + 8";
    double expectedAnswer = -4.0;

    try {
      assertTrue(calc.evaluate(expression) == expectedAnswer);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void BadOperatorTest() {
    String expression = "2 # 3";
    boolean exceptionThrown = false;

    try {
      calc.evaluate(expression);
    } catch (Exception e) {
      exceptionThrown = true;
      assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Bad Operator."));
    }
    assertTrue(exceptionThrown);
  }

  @Test
  public void EmptyExpressionTest() {
    String expression = "";
    boolean exceptionThrown = false;

    try {
      calc.evaluate(expression);
    } catch (Exception e) {
      exceptionThrown = true;
      assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Expression must have at least two operands and one operator."));
    }
    assertTrue(exceptionThrown);
  }

  @Test
  public void BadExpressionTest() {
    String expression = "2 + 3 -";
    boolean exceptionThrown = false;

    try {
      calc.evaluate(expression);
    } catch (Exception e) {
      exceptionThrown = true;
      assertTrue(e.toString().equals("java.lang.IllegalArgumentException: Bad expression."));
    }
    assertTrue(exceptionThrown);
  }

  @Test
  public void BadLeftOperand() {
    String expression = "2s + 3";
    boolean exceptionThrown = false;

    try {
      calc.evaluate(expression);
    } catch (Exception e) {
      exceptionThrown = true;
      assertTrue(e.toString().equals("java.lang.IllegalArgumentException: 2s is not a valid number"));
    }
    assertTrue(exceptionThrown);
  }

  @Test
  public void BadRightOperand() {
    String expression = "2 + 3g";
    boolean exceptionThrown = false;

    try {
      calc.evaluate(expression);
    } catch (Exception e) {
      exceptionThrown = true;
      assertTrue(e.toString().equals("java.lang.IllegalArgumentException: 3g is not a valid number"));
    }
    assertTrue(exceptionThrown);
  }


}
