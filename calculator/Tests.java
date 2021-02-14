package classes;

public class Tests {
  public static void main(String[] args) {
    MathActions actions = new MathActions();
    // tests
    assert (12.0 == actions.count("12*1", true));
    assert (13.2 == actions.count("12.2+1", true));
    assert (11.5 == actions.count("12.5-1", true));
    assert (12.6 == actions.count("12.6/1", true));
    //System.out.println("answer is: " + count("12.6*1", true));
    //System.out.println("answer is: " + count("12.3/1", true));
    //System.out.println("answer is: " + count("12.5+1", true));
    //System.out.println("answer is: " + count("12.1-1", true));
  }

  // copy of the count method for tests
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
    return 0.0; // just for now
  }
}
