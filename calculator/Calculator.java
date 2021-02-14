package classes;

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JTextField text;
  JButton one, two, three, four, five, six, seven, eight, nine, zero;
  JButton equals, multiply, divide, minus, plus, clear;
  JCheckBox addToFile;
  boolean answerCheck = true;
  String count = "";
  MathActions actions = new MathActions();
  static boolean isError = false;

  public Calculator() {
    // settings for frame
    frame = new JFrame("Calculator");
    frame.setLayout(new FlowLayout());
    frame.setSize(500, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new Color(255, 1, 0));

    // initializing other elements
    text = new JTextField(20);

    one = new JButton("1");
    one.addActionListener(this);

    two = new JButton("2");
    two.addActionListener(this);

    three = new JButton("3");
    three.addActionListener(this);

    four = new JButton("4");
    four.addActionListener(this);

    five = new JButton("5");
    five.addActionListener(this);

    six = new JButton("6");
    six.addActionListener(this);

    seven = new JButton("7");
    seven.addActionListener(this);

    eight = new JButton("8");
    eight.addActionListener(this);

    nine = new JButton("9");
    nine.addActionListener(this);

    zero = new JButton("0");
    zero.addActionListener(this);

    equals = new JButton("=");
    equals.addActionListener(this);

    multiply = new JButton("*");
    multiply.addActionListener(this);

    divide = new JButton("/");
    divide.addActionListener(this);

    minus = new JButton("-");
    minus.addActionListener(this);

    plus = new JButton("+");
    plus.addActionListener(this);

    clear = new JButton("C");
    clear.addActionListener(this);

    addToFile = new JCheckBox("Add to file", true);
    addToFile.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        answerCheck = false;
      }
    });

    frame.add(text);
    frame.add(one);
    frame.add(two);
    frame.add(three);
    frame.add(four);
    frame.add(five);
    frame.add(six);
    frame.add(seven);
    frame.add(eight);
    frame.add(nine);
    frame.add(zero);
    frame.add(equals);
    frame.add(multiply);
    frame.add(divide);
    frame.add(minus);
    frame.add(plus);
    frame.add(addToFile);
    frame.add(clear);

    frame.setVisible(true); // making it visible
    frame.setResizable(false); // making it unresizable
  }

  // waiting for clicks
  public void actionPerformed(ActionEvent event) {
    if(event.getActionCommand().equals("C")) {
      text.setText("");
      return;
    }
    if(event.getActionCommand().equals("=")) {
      count = text.getText();
      System.out.println("this is number: " + count);
      text.setText(String.valueOf(actions.count(count, answerCheck)));
      if(isError) text.setText("Error");
      isError = false;
      count = "";
      return;
    }
    text.setText(text.getText() + event.getActionCommand());
    count += text.getText();

    //try {
    //  int numericButton = Integer.parseInt(event.getActionCommand());

    //} catch(NumberFormatException exc) {
      //
    //}


  }

  public static void setError(boolean value) {
    isError = value; // set method
  }

}
