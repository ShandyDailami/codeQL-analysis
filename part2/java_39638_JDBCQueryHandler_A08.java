import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_39638_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Create a statement
            pstmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");

            // Set parameters and execute the statement
            pstmt.setString(1, "testuser");
            pstmt.setString(2, "password");
            pstmt.executeUpdate();

            System.out.println("Records inserted successfully into Users table");
        } catch (SQLException e) {
            System.out.println("SQL Error");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } finally {
            // Clean up environment
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}