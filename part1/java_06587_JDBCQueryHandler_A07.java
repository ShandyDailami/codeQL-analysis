import java.sql.*;
import java.util.Properties;

public class java_06587_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/dbname";

    // Actions that can be performed on the database
    public static void main(String[] args) {
        executeQuery("SELECT * FROM users WHERE id = ?");
        executeUpdate("UPDATE users SET name = ? WHERE id = ?");
    }

    // Handle a query
    public static void executeQuery(String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // Create a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            pstmt = conn.prepareStatement(query);

            // Execute the query
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // Print the first name and last name of each student
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                System.out.println(firstName + " " + lastName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }

    // Handle an update
    public static void executeUpdate(String update) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Create a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            pstmt = conn.prepareStatement(update);

            // Execute the update
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}