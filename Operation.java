package com.calculator;

public class Operation {
    private int id;
    private String operandType;
    private String operation;
    private String operand1;
    private String operand2;
    private String result;
    private String timestamp;

    public Operation(String operandType, String operation, String operand1, String operand2, String result) {
        this.operandType = operandType;
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getOperandType() { return operandType; }
    public void setOperandType(String operandType) { this.operandType = operandType; }

    public String getOperation() { return operation; }
    public void setOperation(String operation) { this.operation = operation; }

    public String getOperand1() { return operand1; }
    public void setOperand1(String operand1) { this.operand1 = operand1; }

    public String getOperand2() { return operand2; }
    public void setOperand2(String operand2) { this.operand2 = operand2; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
