package classes;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.Math.*;

public class Calculator implements ActionListener {
  private JFrame frame;
  private JTextField text, discription;
  private JButton one, two, three, four, five, six, seven, eight, nine, zero;
  private JButton equals, multiply, divide, minus, plus, clear, dot, root, pi, back;
  private JButton submit;
  private JCheckBox addToFile;
  private String first = "";
  private String second = "";
  static boolean isError = false;
  private Font fontForButtons = new Font(Font.MONOSPACED, Font.PLAIN, 100);
  private Font fontForBoxAndText = new Font(Font.MONOSPACED, Font.PLAIN, 50);
  private boolean minusAction = false;
  private boolean plusAction = false;
  private boolean multiplyAction = false;
  private boolean divideAction = false;

  public Calculator() throws IOException {
    // settings for frame
    frame = new JFrame("Calculator");
    frame.setLayout(new FlowLayout());
    frame.setSize(510, 680);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new Color(255, 1, 0));

    // configuring other elements
    text = new JTextField(16);
    text.setFont(fontForBoxAndText);
    text.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e) { // it allows to input only numbers
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) { // if not number just ignore it
            e.consume();
        }
      }
    });
    //text.setEditable(false); // possible but it ignores numbers, too

    discription = new JTextField(15);
    discription.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));

    one = new JButton("1");
    one.addActionListener(this);
    one.setFont(fontForButtons);

    two = new JButton("2");
    two.addActionListener(this);
    two.setFont(fontForButtons);

    three = new JButton("3");
    three.addActionListener(this);
    three.setFont(fontForButtons);

    four = new JButton("4");
    four.addActionListener(this);
    four.setFont(fontForButtons);

    five = new JButton("5");
    five.addActionListener(this);
    five.setFont(fontForButtons);

    six = new JButton("6");
    six.addActionListener(this);
    six.setFont(fontForButtons);

    seven = new JButton("7");
    seven.addActionListener(this);
    seven.setFont(fontForButtons);

    eight = new JButton("8");
    eight.addActionListener(this);
    eight.setFont(fontForButtons);

    nine = new JButton("9");
    nine.addActionListener(this);
    nine.setFont(fontForButtons);

    zero = new JButton("0");
    zero.addActionListener(this);
    zero.setFont(fontForButtons);

    equals = new JButton("= ");
    equals.addActionListener(this);
    equals.setFont(fontForButtons);

    multiply = new JButton("*");
    multiply.addActionListener(this);
    multiply.setFont(fontForButtons);

    divide = new JButton("/");
    divide.addActionListener(this);
    divide.setFont(fontForButtons);

    minus = new JButton("-");
    minus.addActionListener(this);
    minus.setFont(fontForButtons);

    plus = new JButton("+");
    plus.addActionListener(this);
    plus.setFont(fontForButtons);

    clear = new JButton("C");
    clear.addActionListener(this);
    clear.setFont(fontForButtons);

    dot = new JButton(".");
    dot.addActionListener(this);
    dot.setFont(fontForButtons);

    root = new JButton("√");
    root.addActionListener(this);
    root.setFont(fontForButtons);

    pi = new JButton("π");
    pi.addActionListener(this);
    pi.setFont(fontForButtons);

    back = new JButton("←");
    back.addActionListener(this);
    back.setFont(fontForButtons);

    submit = new JButton("submit");
    submit.addActionListener(this);
    submit.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));

    addToFile = new JCheckBox("Add to file", true);
    // ItemListener is not necessary here
    addToFile.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));

    // adding all elements
    frame.add(text);
    frame.add(clear);
    frame.add(one);
    frame.add(two);
    frame.add(three);
    frame.add(back);
    frame.add(minus);
    frame.add(four);
    frame.add(five);
    frame.add(six);
    frame.add(plus);
    frame.add(divide);
    frame.add(seven);
    frame.add(eight);
    frame.add(nine);
    frame.add(multiply);
    frame.add(pi);
    frame.add(dot);
    frame.add(zero);
    //frame.add(root);
    frame.add(equals);
    frame.add(discription);
    frame.add(submit);
    frame.add(addToFile);

    SwingUtilities.updateComponentTreeUI(frame); // making correct size
    frame.setVisible(true); // making it visible
    frame.setResizable(false); // making it unresizable
  }

  // waiting for clicks
  public void actionPerformed(ActionEvent event) {
    if(event.getActionCommand().equals("submit")) {
      String discriptionText = discription.getText();
      try (FileWriter file = new FileWriter("countings.txt", true)) {
        file.write("\n" + discriptionText + "\n");
        discription.setText(""); // clearing
        discriptionText = ""; // clearing
        return; // otherwise, it will add it to text component(JTextField)
        // I don't need to close file because it I use try-with-resources
      } catch(IOException exc) {
        discription.setText("Error");
      }
    }
    if(event.getActionCommand().equals("C")) {
      text.setText(""); // clearing jfield
      first = ""; // clearing variables that contain numbers
      second = "";
      return;
    }

    if(event.getActionCommand().equals("←")) {
      StringBuffer sb = new StringBuffer(text.getText());
      sb.deleteCharAt(text.getText().length() - 1);
      String str = sb.toString();
      text.setText(str);
      return;
    }

    if(event.getActionCommand().equals("= ")) {
      second = text.getText();
      double result;

      try(FileWriter out = new FileWriter("countings.txt", true)) {
        // adding
        if(plusAction) {
          StringBuilder sbuild = new StringBuilder(second);
          sbuild.deleteCharAt(0);
          second = sbuild.toString();
          result = MathActions.plus(first, second);
          text.setText(String.valueOf(result));
          if(addToFile.isSelected()) {
            out.write(first + " + " + second + " = " + result + "\n");
          }
          plusAction = false;
        }

        //minusing
        if(minusAction) {
          StringBuilder sbuild = new StringBuilder(second);
          sbuild.deleteCharAt(0);
          second = sbuild.toString();
          result = MathActions.minus(first, second);
          text.setText(String.valueOf(result));
          if(addToFile.isSelected()) {
            out.write(first + " - " + second + " = " + result + "\n");
          }
          minusAction = false;
        }

        // multiplying
        if(multiplyAction) {
          StringBuilder sbuild = new StringBuilder(second);
          sbuild.deleteCharAt(0);
          second = sbuild.toString();
          result = MathActions.multiply(first, second);
          text.setText(String.valueOf(result));
          if(addToFile.isSelected()) {
            out.write(first + " * " + second + " = " + result + "\n");
          }
          multiplyAction = false;
        }

        // dividing
        if(divideAction) {
          StringBuilder sbuild = new StringBuilder(second);
          sbuild.deleteCharAt(0);
          second = sbuild.toString();
          result = MathActions.divide(first, second);
          text.setText(String.valueOf(result));
          if(addToFile.isSelected()) {
            out.write(first + " / " + second + " = " + result + "\n");
          }
          divideAction = false;
        }

        if(isError) {
          text.setText("Error");
        }
        isError = false;
        first = "";
        second = "";
        return;
      } catch(IOException exc) {
        text.setText("Can't write in file");
      }
    }

    if(event.getActionCommand().equals("-")) {
      first = text.getText();
      text.setText(""); // clearing field
      minusAction = true;
    }

    if(event.getActionCommand().equals("+")) {
      first = text.getText();
      text.setText(""); // clearing field
      plusAction = true;
    }

    if(event.getActionCommand().equals("*")) {
      first = text.getText();
      text.setText(""); // clearing field
      multiplyAction = true;
    }

    if(event.getActionCommand().equals("/")) {
      first = text.getText();
      text.setText(""); // clearing field
      divideAction = true;
    }
    text.setText(text.getText() + event.getActionCommand());
    second += text.getText();
  }

  public static void setError(boolean value) {
    isError = value;
  }
}
