import java.sql.*;

public class java_09140_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // A07_AuthFailure begins here
        // Find a user by their ID
        String query = "SELECT * FROM Users WHERE id = ?";
        try {
            ResultSet rs = stmt.executeQuery(query + " 1");
            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // A07_AuthFailure ends here
    }
}