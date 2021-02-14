package classes;

import java.util.Arrays;

public class MathActions {
  public static double count(String expression, boolean addToFile) {
    // multiply
    double answer = 0.0;
    if(expression.contains("*")) {
      String[] array = expression.split("\\*"); // because it is a reges symbol
      try {
        double first = Double.parseDouble(array[0]); // taking number
        double second = Double.parseDouble(array[1]); // taking number
        System.out.println(first + " and " + second);
        answer = first * second;
        return answer;
        //Calculator.text.setText(answer); // showing answer
      } catch(NumberFormatException exc) {
        //Calculator.text.setText("Error"); // if there is a mistake
      }
    }

    // divide
    if(expression.contains("/")) {
      String[] array = expression.split("\\/"); // because it is a reges symbol
      try {
        double first = Double.parseDouble(array[0]); // taking number
        double second = Double.parseDouble(array[1]); // taking number
        System.out.println(first + " and " + second);
        answer = first / second;
        return answer;
        //Calculator.text.setText(answer); // showing answer
      } catch(NumberFormatException exc) {
        //Calculator.text.setText("Error"); // if there is a mistake
      }
    }

    // plus
    if(expression.contains("+")) {
      String[] array = expression.split("\\+"); // because it is a reges symbol
      try {
        double first = Double.parseDouble(array[0]); // taking number
        double second = Double.parseDouble(array[1]); // taking number
        System.out.println(first + " and " + second);
        answer = first + second;
        return answer;
        //Calculator.text.setText(answer); // showing answer
      } catch(NumberFormatException exc) {
        //Calculator.text.setText("Error"); // if there is a mistake
      }
    }

    // minus
    if(expression.contains("-")) {
      String[] array = expression.split("\\-"); // because it is a reges symbol
      try {
        double first = Double.parseDouble(array[0]); // taking number
        double second = Double.parseDouble(array[1]); // taking number
        System.out.println(first + " and " + second);
        answer = first - second;
        return answer;
        //Calculator.text.setText(answer); // showing answer
      } catch(NumberFormatException exc) {
        //Calculator.text.setText("Error"); // if there is a mistake
      }
    }
    Calculator.setError(true);
    return 0.0; // just for now
  }

}
