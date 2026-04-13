import java.sql.*;

public class java_15353_JDBCQueryHandler_A07 {

    // In a real-world application, these would likely come from configuration or a secure storage
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public boolean login(String username, String password) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare a statement for execution
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");

            // Step 3: Set parameters and execute the statement
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Handle the result (This is where security-sensitive operations are performed)
            if (rs.next()) {
                // Authentication successful
                return true;
            } else {
                // Authentication failed
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("SQL Exception occurred: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        boolean loginSuccess = handler.login("username", "password");
        System.out.println("Login Success: " + loginSuccess);
    }
}