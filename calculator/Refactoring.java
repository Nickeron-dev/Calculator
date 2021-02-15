package classes;

import java.lang.*;

public class Refactoring {
  public static void main(String[] args) {
    // Unit tests
    assert (12.0 == MathActions.multiply("12", "1"));
    assert (17.2 == MathActions.plus("12.2", "5"));
    assert (-87.5 == MathActions.minus("12.5", "100"));
    assert (10.0 == MathActions.divide("25", "2.5"));

    // just test
    Double value = Math.PI;
    System.out.println("pi in double is: " + value);
    System.out.println("all tests are completed!!!");
  }
}
