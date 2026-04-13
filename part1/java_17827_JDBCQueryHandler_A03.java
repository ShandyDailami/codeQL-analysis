import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17827_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Prepare the statement
            stmt = conn.prepareStatement("SELECT * FROM mytable");

            // Execute the statement
            rs = stmt.executeQuery();

            // Process the ResultSet
            while (rs.next()) {
                String column1 = rs.getString("column1");
                String column2 = rs.getString("column2");
                //... process the columns
            }
        } catch (SQLException e) {
            System.out.println("Error in database query: " + e.getMessage());
        } finally {
            // Close the resources
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // ignore close exception
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // ignore close exception
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // ignore close exception
                }
            }
        }
    }
}