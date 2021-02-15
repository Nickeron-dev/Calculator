package classes;

import java.util.Arrays;

public class MathActions {
  public static double plus(String first, String second) {
    try {
      Double firstValue = null;
      Double secondValue = null;
      boolean isFirstReady = false;
      boolean isSecondReady = false;
      double answer = Math.PI + Math.PI;

      // if first value is π
      if(first.equals("π")) {
        firstValue = Math.PI;
        isFirstReady = true;
      }

      // if second value is π
      if(second.equals("π")) {
        secondValue = Math.PI;
        isSecondReady = true;
      }

      if(!isFirstReady) { // bringing value back
        firstValue = Double.parseDouble(first); // getting double
      }

      if(!isSecondReady) { // bringing value back
        secondValue = Double.parseDouble(second); // getting double
      }

      answer = firstValue + secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }

    Calculator.setError(true);
    return 0.0; // just for now
  }

  public static double minus(String first, String second) {
    try {
      Double firstValue = null;
      Double secondValue = null;
      boolean isFirstReady = false;
      boolean isSecondReady = false;
      double answer = Math.PI - Math.PI;

      // if first value is π
      if(first.equals("π")) {
        firstValue = Math.PI;
        isFirstReady = true;
      }

      // if second value is π
      if(second.equals("π")) {
        secondValue = Math.PI;
        isSecondReady = true;
      }

      if(!isFirstReady) { // bringing value back
        firstValue = Double.parseDouble(first); // getting double
      }

      if(!isSecondReady) { // bringing value back
        secondValue = Double.parseDouble(second); // getting double
      }

      answer = firstValue - secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }

  public static double multiply(String first, String second) {
    try {
      Double firstValue = null;
      Double secondValue = null;
      boolean isFirstReady = false;
      boolean isSecondReady = false;
      double answer = Math.PI * Math.PI;

      // if first value is π
      if(first.equals("π")) {
        firstValue = Math.PI;
        isFirstReady = true;
      }

      // if second value is π
      if(second.equals("π")) {
        secondValue = Math.PI;
        isSecondReady = true;
      }

      if(!isFirstReady) { // bringing value back
        firstValue = Double.parseDouble(first); // getting double
      }

      if(!isSecondReady) { // bringing value back
        secondValue = Double.parseDouble(second); // getting double
      }

      answer = firstValue * secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }

  public static double divide(String first, String second) {
    try {
      Double firstValue = null;
      Double secondValue = null;
      boolean isFirstReady = false;
      boolean isSecondReady = false;
      double answer = Math.PI / Math.PI;

      // if first value is π
      if(first.equals("π")) {
        firstValue = Math.PI;
        isFirstReady = true;
      }

      // if second value is π
      if(second.equals("π")) {
        secondValue = Math.PI;
        isSecondReady = true;
      }

      if(!isFirstReady) { // bringing value back
        firstValue = Double.parseDouble(first); // getting double
      }

      if(!isSecondReady) { // bringing value back
        secondValue = Double.parseDouble(second); // getting double
      }

      answer = firstValue / secondValue;
      return answer;
    } catch(NumberFormatException exc) {
      Calculator.setError(true);
    }
    return 0.0; // it is impossible to get there so there's no differece
  }
}
