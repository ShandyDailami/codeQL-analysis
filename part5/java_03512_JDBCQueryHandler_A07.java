import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03512_JDBCQueryHandler_A07 {

    private Connection conn;
    private PreparedStatement pstmt;

    public java_03512_JDBCQueryHandler_A07(String dbURL, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void verifyUser(String username, String password) {
        String query = "SELECT * FROM USERS WHERE USERNAME = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("PASSWORD");
                if (password.equals(dbPassword)) {
                    System.out.println("Login successful!");
                } else {
                    logAuthFailure(username);
                }
            } else {
                logAuthFailure(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void logAuthFailure(String username) {
        System.out.println("Auth failure for user: " + username);
        // Here, you can add the logic for logging the failure
    }
}