import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_01758_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load MySQL Connector/J library
            // Step 2: Establish a connection to MySQL database
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO Users (id, name, password) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Step 3: Insert a row into table Users
            pstmt.setInt(1, 1);
            pstmt.setString(2, "John Doe");
            pstmt.setString(3, "password123");

            // Step 4: Execute SQL query
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}