import java.sql.*;

public class java_26694_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // SQL query to insert a new user
    private static final String USER_INSERT_QUERY = "INSERT INTO Users (username, password, role_id) VALUES (?, ?, ?)";

    // SQL query to insert a new role
    private static final String ROLE_INSERT_QUERY = "INSERT INTO Roles (role_name) VALUES (?)";

    public static void main(String[] args) {
        // Create a new connection
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);

            // Create a new user and role
            int userId = 1;
            String userName = "user1";
            String password = "password1";
            int roleId = 2;

            // Insert the new user
            pstmt = conn.prepareStatement(USER_INSERT_QUERY);
            pstmt.setInt(1, userId);
            pstmt.setString(2, password);
            pstmt.setInt(3, roleId);
            pstmt.executeUpdate();

            // Insert the new role (security-sensitive operation)
            pstmt = conn.prepareStatement(ROLE_INSERT_QUERY);
            pstmt.setString(1, "ADMIN");
            pstmt.executeUpdate();

            // Commit the transaction
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Close the statement and connection
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