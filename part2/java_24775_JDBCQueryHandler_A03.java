import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_24775_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Prepare a statement
            pstmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");

            // Set parameters and execute statement
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "hashedPassword"); // Assume we have a function to hash the password
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}