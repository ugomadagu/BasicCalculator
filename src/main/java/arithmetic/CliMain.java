package arithmetic;

import java.io.Console;

public class CliMain {
  public static void main(String[] args) {
    Console c = System.console();
    Calculator calc = new Calculator();

    System.out.println("Please enter your arithmetic expressions below.");
    while(true) {
      String line = c.readLine().trim();
      if(line.equals("exit")) {
        break;
      } else {
        try{
          System.out.println(calc.evaluate(line));
        } catch(Exception e) {
          System.out.println(e);
        }
      }
    }
  }
}
