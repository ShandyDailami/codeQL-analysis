import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06873_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "myuser";
    private static final String password = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to the MySQL database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Run a SQL query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up: Close the ResultSet, Statement and Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}