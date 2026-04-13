import java.sql.*;

public class java_29436_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Attempt to login as user A07_AuthFailure
            String sql = "SELECT * FROM Users WHERE username = 'A07_AuthFailure'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // User exists and is not blocked
                System.out.println("Login successful as user: A07_AuthFailure");
            } else {
                // User does not exist or is blocked
                System.out.println("Login failed for user: A07_AuthFailure. User does not exist or is blocked.");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("SQL Exception occurred: " + e.getMessage());
        }
    }
}