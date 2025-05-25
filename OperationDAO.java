package com.calculator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scientific_calculator";
    private static final String USER = "root";
    private static final String PASS = "your_password";

    public void insertOperation(Operation op) {
        String sql = "INSERT INTO operations (operand_type, operation, operand_1, operand_2, result) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, op.getOperandType());
            pstmt.setString(2, op.getOperation());
            pstmt.setString(3, op.getOperand1());
            pstmt.setString(4, op.getOperand2());
            pstmt.setString(5, op.getResult());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Operation> getAllOperations() {
        List<Operation> list = new ArrayList<>();
        String sql = "SELECT * FROM operations ORDER BY timestamp DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operation op = new Operation(
                    rs.getString("operand_type"),
                    rs.getString("operation"),
                    rs.getString("operand_1"),
                    rs.getString("operand_2"),
                    rs.getString("result")
                );
                op.setId(rs.getInt("operation_id"));
                op.setTimestamp(rs.getString("timestamp"));
                list.add(op);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
