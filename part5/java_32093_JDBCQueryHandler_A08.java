import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32093_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/legacydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName(DB_DRIVER);

            // Step 2: Establish the connection with the database
            con = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare SQL statement
            String sql = "INSERT INTO Users (id, name, email) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            // Set parameters
            pstmt.setInt(1, 100);
            pstmt.setString(2, "Test User");
            pstmt.setString(3, "test.user@example.com");

            // Step 4: Execute the query
            pstmt.executeUpdate();

            System.out.println("Inserted successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up environment
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}