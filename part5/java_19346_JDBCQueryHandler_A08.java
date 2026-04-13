import java.sql.*;

public class java_19346_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // 1. Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE password = 'mypassword'");

            // 4. Process the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // 5. Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}