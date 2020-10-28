import java.awt.*;
import java.awt.event.*;
import java.awt.Container;
import javax.swing.*;

public class ReversePolishCalc extends JFrame implements ActionListener {
    final int windowBounds = 350;
    final int calcOrgin = 10;
    final int calcXBounds = 330;
    final int calcYBounds = 295;
    final int generalX = 50;
    final int puButtonX = 0;
    final int generalY = 30;
    LinkList Stack = new LinkList();
    JFrame frame;
    JLabel labelStack;
    JLabel labelInput;
    JButton plus;
    JButton minus;
    JButton multiply;
    JButton divide;
    JButton push;
    JButton pop;
    JTextField input;
    JTextArea stack;

    public void plus() {
        int A = Stack.pop();
        int B = Stack.pop();
        int C = A + B;
        Stack.push(C);
        stack.setText(Stack.stackPrint());
    }

    public void minus() {
        int A = Stack.pop();
        int B = Stack.pop();
        int C = A - B;
        Stack.push(C);
        stack.setText(Stack.stackPrint());
    }

    public void multiply() {
        int A = Stack.pop();
        int B = Stack.pop();
        int C = A * B;
        Stack.push(C);
        stack.setText(Stack.stackPrint());
    }

    public void divide() {
        int A = Stack.pop();
        int B = Stack.pop();
        int C = A / B;
        Stack.push(C);
        stack.setText(Stack.stackPrint());
    }

    //Create the ActionEvent
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Push")) {
            System.out.println("Push");
            try{
                Integer i = new Integer(input.getText());
                Stack.push(i);
                stack.setText(Stack.stackPrint());
            }
            catch(Exception ex){
                input.setText("");
                stack.setText(Stack.stackPrint());
            }
        } 
        else if (e.getActionCommand().equals("Pop")) {
            System.out.println("Pop");
            Stack.pop();
            stack.setText(Stack.stackPrint());
        } 
        else if (e.getActionCommand().equals("+")) {
            System.out.println("+");
            plus();
        }
        else if (e.getActionCommand().equals("-")) {
            System.out.println("-");
            minus();
        }
        else if (e.getActionCommand().equals("*")) {
            System.out.println("*");
            multiply();
        }
        else if (e.getActionCommand().equals("/")) {
            System.out.println("/");
            divide();
        }
    }

    public ReversePolishCalc() {
        // Create the JFrame
        frame = new JFrame("Reverse Polish Calculator");

        // Create the Label
        labelStack = new JLabel("Stack");
        labelStack.setBounds(calcOrgin * 5, calcOrgin * 2, generalX, generalY);
        labelInput = new JLabel("Input");
        labelInput.setBounds(calcOrgin * 17, calcOrgin * 2, generalX, generalY);

        // Create the Buttons
        // Plus
        plus = new JButton("+");
        plus.addActionListener(this);
        plus.setBounds(calcOrgin * 17, calcOrgin * 11, generalX, generalY);
        plus.setBackground(Color.LIGHT_GRAY);
        // Minus
        minus = new JButton("-");
        minus.addActionListener(this);
        minus.setBounds(calcOrgin * 23, calcOrgin * 11, generalX, generalY);
        minus.setBackground(Color.LIGHT_GRAY);
        // Multiply
        multiply = new JButton("*");
        multiply.addActionListener(this);
        multiply.setBounds(calcOrgin * 17, calcOrgin * 15, generalX, generalY);
        multiply.setBackground(Color.LIGHT_GRAY);
        // Divide
        divide = new JButton("/");
        divide.addActionListener(this);
        divide.setBounds(calcOrgin * 23, calcOrgin * 15, generalX, generalY);
        divide.setBackground(Color.LIGHT_GRAY);
        // Push
        push = new JButton("Push");
        push.addActionListener(this);
        push.setBounds(calcOrgin * 24, calcOrgin * 5, calcOrgin * 8, calcOrgin * 4);
        push.setBackground(Color.YELLOW);
        // Pop
        pop = new JButton("Pop");
        pop.addActionListener(this);
        pop.setBounds(calcOrgin * 3, calcOrgin * 26, calcOrgin * 8, calcOrgin * 4);
        pop.setBackground(Color.RED);
        pop.setForeground(Color.WHITE);

        // Create TextField
        input = new JTextField();
        input.setBounds(calcOrgin * 15, calcOrgin * 5, calcOrgin * 8, calcOrgin * 4);

        // Create TextArea
        stack = new JTextArea();
        stack.setBounds(calcOrgin * 2, calcOrgin * 5, calcOrgin * 10, calcOrgin * 20);

        // Set up the JFrame
        frame.add(labelStack);
        frame.add(labelInput);
        frame.add(stack);
        frame.add(input);
        frame.add(push);
        frame.add(pop);
        frame.add(plus);
        frame.add(minus);
        frame.add(multiply);
        frame.add(divide);
        frame.setSize(windowBounds, windowBounds);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.repaint();
    }

    public static void main(String[] args) {
        ReversePolishCalc theapp = new ReversePolishCalc();
    }
}
