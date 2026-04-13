import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_38871_JDBCQueryHandler_A08 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE id = ?");
            pstmt.setInt(1, 123); // replace 123 with the actual user id

            // Step 3: Execute the statement
            rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                System.out.println("Name: " + name);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the resources
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Always close the resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}