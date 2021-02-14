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
  JButton equals, multiply, divide, minus, plus, clear, dot, root, pi, back;
  JCheckBox addToFile;
  boolean answerCheck = true;
  String count = "";
  MathActions actions = new MathActions();
  static boolean isError = false;
  Font fontForButtons = new Font(Font.MONOSPACED, Font.PLAIN, 100);
  Font fontForBoxAndText = new Font(Font.MONOSPACED, Font.PLAIN, 50);

  public Calculator() {
    // settings for frame
    frame = new JFrame("Calculator");
    frame.setLayout(new FlowLayout());
    frame.setSize(510, 700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new Color(255, 1, 0));

    // initializing other elements
    text = new JTextField(16);
    text.setFont(fontForBoxAndText);

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

    equals = new JButton("=");
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

    addToFile = new JCheckBox("Add to file", true);
    addToFile.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent event) {
        answerCheck = false;
      }
    });
    addToFile.setFont(fontForBoxAndText);

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
    frame.add(root);
    frame.add(equals);
    frame.add(addToFile);

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
