import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09852_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "myuser";
            String password = "mypassword";

            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable WHERE mycolumn = 'myvalue'");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                System.out.println("Found a row in mytable");
                // Perform security-sensitive operations
                // ...
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the ResultSet, Statement, and Connection
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