import java.sql.*;

public class java_06941_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            // Start the SQL query
            ResultSet rs = stmt.executeQuery("SELECT password FROM users WHERE username = 'targetusername'");

            if (rs.next()) {
                String targetPassword = rs.getString("password");
                System.out.println("Target password: " + targetPassword);
            } else {
                System.out.println("No target user found");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}