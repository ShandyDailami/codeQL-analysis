import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_06993_JDBCQueryHandler_A07 {
    // A07_AuthFailure related operations
    public static boolean authenticateUser(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/test"; // replace with your actual database info
        String user = "root"; // replace with your actual username
        String passwordDB = "password"; // replace with your actual password

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, user, passwordDB);

            // Prepare SQL statement
            String SQL = "SELECT USERNAME FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute query
            pstmt.execute();

            // Handle the result

            // Close resources
            pstmt.close();
            conn.close();

            // Check if there's a result
            if (pstmt.getUpdateCount() == 1) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        boolean userExists = authenticateUser("user1", "password1");
        System.out.println(userExists);
    }
}