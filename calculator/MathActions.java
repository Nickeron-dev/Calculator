package classes;

import java.util.Arrays;

public class MathActions {
  public static double plus(String first, String second, boolean addToFile) {
    try {
      Double firstValue = Double.parseDouble(first); // getting double
      Double secondValue = Double.parseDouble(second); // getting double
      double answer = firstValue + secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }

    Calculator.setError(true);
    return 0.0; // just for now
  }

  public static double minus(String first, String second, boolean addToFile) {
    try {
      Double firstValue = Double.parseDouble(first); // getting double
      Double secondValue = Double.parseDouble(second); // getting double
      double answer = firstValue - secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }

  public static double multiply(String first, String second, boolean addToFile) {
    try {
      Double firstValue = Double.parseDouble(first); // getting double
      Double secondValue = Double.parseDouble(second); // getting double
      double answer = firstValue * secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }

  public static double divide(String first, String second, boolean addToFile) {
    try {
      Double firstValue = Double.parseDouble(first); // getting double
      Double secondValue = Double.parseDouble(second); // getting double
      double answer = firstValue / secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }
}
