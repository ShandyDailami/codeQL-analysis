import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_41267_JDBCQueryHandler_A07 {
    // DB credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Method to establish DB connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Method to handle authentication failures
    public boolean authFailure() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?");
            pstmt.setString(1, "user1");
            pstmt.setString(2, "pass1");
            pstmt.execute();

            rs = pstmt.getResultSet();
            if (rs.next()) {
                System.out.println("User found!");
                return true;
            } else {
                System.out.println("User not found!");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }

        return false;
    }

    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.authFailure();
    }
}