import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39359_JDBCQueryHandler_A07 {

    // URL of the database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    // Username and password for the database
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement
            stmt = conn.createStatement();

            // Start by dropping the table if it exists
            stmt.executeUpdate("DROP TABLE IF EXISTS AuthFailure");

            // Create the table
            stmt.executeUpdate("CREATE TABLE AuthFailure (" +
                    "id INT PRIMARY KEY," +
                    "username VARCHAR(50)," +
                    "password VARCHAR(50)," +
                    "email VARCHAR(50))");

            // Insert a row of data
            stmt.executeUpdate("INSERT INTO AuthFailure VALUES (1, 'user1', 'pass1', 'user1@mail.com')");

            // Now, let's authenticate the user
            String query = "SELECT * FROM AuthFailure WHERE username = '" + USER + "' AND password = '" + PASS + "'";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("Authenticated successfully!");
            } else {
                System.out.println("Authentication failed!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and the connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}