import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_11543_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Setup the database connection
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a new statement
            stmt = conn.createStatement();

            // Execute a query
            String sql = "SELECT * FROM your_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Process the results
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                // You can add more columns to be processed here
            }

            // Close the statement and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}