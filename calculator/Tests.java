package classes;

public class Tests {
  public static void main(String[] args) {
    // tests
    assert (12.0 == MathActions.multiply("12", "1", true));
    assert (17.2 == MathActions.plus("12.2", "5", true));
    assert (-87.5 == MathActions.minus("12.5", "100", true));
    assert (10.0 == MathActions.divide("25", "2.5", true));
    System.out.println("all tests are completed!!!");
  }
}
