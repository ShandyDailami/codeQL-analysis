import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39979_JDBCQueryHandler_A01 {
    // define the database URL, username and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 2: Create a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Step 3: Create a statement
            stmt = conn.createStatement();
            // Step 4: Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM myTable");
            // Step 5: Process the ResultSet
            while (rs.next()) {
                // Accessing data using the ResultSet methods
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // Process the data
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the ResultSet, Statement and Connection
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