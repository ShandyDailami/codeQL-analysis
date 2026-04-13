import java.sql.*;

public class java_10612_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myusername";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'admin' AND password = 'password'");

            // Step 4: Handle the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 5: Close the result set and statement
            rs.close();
            stmt.close();

            // Step 6: Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}