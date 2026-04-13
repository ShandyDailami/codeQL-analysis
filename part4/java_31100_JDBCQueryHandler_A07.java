import java.sql.*;

public class java_31100_JDBCQueryHandler_A07 {
    // private variables for database connection
    private Connection conn = null;

    // SQL query for user login
    private final String LOGIN_QUERY = "SELECT * FROM Users WHERE username = ? AND password = ?";

    // Connect to the database
    public java_31100_JDBCQueryHandler_A07() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Prepare SQL query
            pstmt = conn.prepareStatement(LOGIN_QUERY);

            // Set query parameters
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute query
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}