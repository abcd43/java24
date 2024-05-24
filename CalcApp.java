import java.awt.*;
import java.awt.event.*;

public class CalcApp extends Frame implements ActionListener {
    TextField t1, t2, t3;
    Button addButton, subButton, mulButton, divButton;

    public CalcApp() {
        setTitle("Calculator App");
        setLayout(new FlowLayout());
        
        setBackground(Color.GRAY);

        t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);
        t1.setFont(new Font("Arial", Font.PLAIN, 14));
        t2.setFont(new Font("Arial", Font.PLAIN, 14));
        t3.setFont(new Font("Arial", Font.PLAIN, 14));
        t3.setEditable(false);

        addButton = new Button("Add");
        subButton = new Button("Subtract");
        mulButton = new Button("Multiply");
        divButton = new Button("Divide");

        add(new Label("Enter the value 1:"));
        add(t1);
        add(new Label("Enter the value 2:"));
        add(t2);
        add(new Label("Result:"));
        add(t3);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        
        setSize(300, 300);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent a) {
        float num1 = 0, num2 = 0, result = 0;
        try {
            num1 = Float.parseFloat(t1.getText());
            num2 = Float.parseFloat(t2.getText());
        } catch (NumberFormatException ex) {
            t3.setText("Invalid Input");
            return;
        }

        if (a.getSource() == addButton) {
            result = num1 + num2;
        } else if (a.getSource() == subButton) {
            result = num1 - num2;
        } else if (a.getSource() == mulButton) {
            result = num1 * num2;
        } else if (a.getSource() == divButton) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                t3.setText("Error: Division By Zero");
                return;
            }
        }

        t3.setText(String.valueOf(result));
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        new CalcApp();
    }
}

