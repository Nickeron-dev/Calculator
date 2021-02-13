package classes;

import java.awt.*;
import javax.swing.*;


public class CalculatorMain {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Calculator();
      }
    });
  }
}
