package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CalculatorUI extends JFrame {
    private JTextField operand1Field, operand2Field, resultField;
    private JComboBox<String> operationBox;
    private JButton calculateBtn, historyBtn;
    private OperationDAO dao = new OperationDAO();

    public CalculatorUI() {
        setTitle("Scientific Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // UI Components
        operand1Field = new JTextField();
        operand2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        String[] operations = { "add", "subtract", "multiply", "divide", "sin", "cos", "tan", "log", "ln" };
        operationBox = new JComboBox<>(operations);

        calculateBtn = new JButton("Calculate");
        historyBtn = new JButton("View History");

        // Layout
        add(new JLabel("Operand 1:"));
        add(operand1Field);
        add(new JLabel("Operand 2:"));
        add(operand2Field);
        add(new JLabel("Operation:"));
        add(operationBox);
        add(new JLabel("Result:"));
        add(resultField);
        add(calculateBtn);
        add(historyBtn);

        // Event
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCalculation();
            }
        });

        historyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        });

        setVisible(true);
    }

    private void performCalculation() {
        String op1Text = operand1Field.getText().trim();
        String op2Text = operand2Field.getText().trim();
        String operation = (String) operationBox.getSelectedItem();

        Calculator calc = new Calculator();
        String result = "";

        try {
            switch (operation) {
                case "add":
                    result = String.valueOf(Float.parseFloat(op1Text) + Float.parseFloat(op2Text));
                    break;
                case "subtract":
                    result = String.valueOf(Float.parseFloat(op1Text) - Float.parseFloat(op2Text));
                    break;
                case "multiply":
                    result = String.valueOf(Float.parseFloat(op1Text) * Float.parseFloat(op2Text));
                    break;
                case "divide":
                    result = String.valueOf(Float.parseFloat(op1Text) / Float.parseFloat(op2Text));
                    break;
                case "sin":
                    result = String.valueOf(calc.sin(Double.parseDouble(op1Text)));
                    break;
                case "cos":
                    result = String.valueOf(calc.cos(Double.parseDouble(op1Text)));
                    break;
                case "tan":
                    result = String.valueOf(calc.tan(Double.parseDouble(op1Text)));
                    break;
                case "log":
                    result = String.valueOf(calc.log(Double.parseDouble(op1Text)));
                    break;
                case "ln":
                    result = String.valueOf(calc.ln(Double.parseDouble(op1Text)));
                    break;
            }

            resultField.setText(result);

            // Log in DB
            dao.insertOperation(new Operation("float", operation, op1Text, op2Text, result));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input or operation.");
        }
    }

    private void showHistory() {
        List<Operation> history = dao.getAllOperations();
        StringBuilder sb = new StringBuilder("=== Operation History ===\n");
        for (Operation op : history) {
            sb.append(String.format("[%s] %s %s %s = %s\n",
                    op.getTimestamp(),
                    op.getOperand1(),
                    op.getOperation(),
                    op.getOperand2(),
                    op.getResult()));
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}
