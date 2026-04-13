import java.sql.*;

public class java_21245_JDBCQueryHandler_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Employee (name, email) VALUES (?, ?)")) {

            // Set parameters
            pstmt.setString(1, "John Doe");
            pstmt.setString(2, "john.doe@example.com");

            // Execute the statement
            int affectedRows = pstmt.executeUpdate();
            System.out.println("Affected rows: " + affectedRows);

        } catch (SQLException e) {
            System.out.println("Error in SQL query: " + e.getMessage());
        }
    }
}