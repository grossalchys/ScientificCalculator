package com.calculator;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scientific_calculator";
    private static final String USER = "root";
    private static final String PASS = "your_password";

    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS operations (" +
                     "operation_id INT AUTO_INCREMENT PRIMARY KEY," +
                     "operand_type VARCHAR(20)," +
                     "operation VARCHAR(20)," +
                     "operand_1 VARCHAR(50)," +
                     "operand_2 VARCHAR(50)," +
                     "result VARCHAR(50)," +
                     "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Database table created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void logOperation(String operandType, String operation,
                                    String operand1, String operand2, String result) {
        String sql = "INSERT INTO operations (operand_type, operation, operand_1, operand_2, result) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, operandType);
            pstmt.setString(2, operation);
            pstmt.setString(3, operand1);
            pstmt.setString(4, operand2);
            pstmt.setString(5, result);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printHistory() {
        String sql = "SELECT * FROM operations ORDER BY timestamp DESC";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("=== Operation History ===");
            while (rs.next()) {
                System.out.printf("[%s] %s %s %s = %s
",
                                  rs.getTimestamp("timestamp"),
                                  rs.getString("operand_1"),
                                  rs.getString("operation"),
                                  rs.getString("operand_2"),
                                  rs.getString("result"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
