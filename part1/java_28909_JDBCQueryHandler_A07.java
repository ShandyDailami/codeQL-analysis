import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_28909_JDBCQueryHandler_A07 {
    // define your database credentials here
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_28909_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public boolean isValidUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.execute();
            return pstmt.getResultSet().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        AuthFailureHandler authFailureHandler = new AuthFailureHandler();

        String username = "invalid_username"; // replace with the username you want to check
        if (authFailureHandler.isValidUser(username)) {
            System.out.println("User " + username + " exists and is valid.");
        } else {
            System.out.println("User " + username + " does not exist or is not valid.");
        }
    }
}