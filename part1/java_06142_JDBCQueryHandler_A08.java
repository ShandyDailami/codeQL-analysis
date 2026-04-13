import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06142_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            stmt = conn.createStatement();

            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM mytable");

            // Process the ResultSet
            while (rs.next()) {
                // Extract data from the ResultSet
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");
                double column3 = rs.getDouble("column3");

                System.out.println("Column1: " + column1);
                System.out.println("Column2: " + column2);
                System.out.println("Column3: " + column3);
            }
        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
        } finally {
            // Close the resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connections: " + e.getMessage());
            }
        }
    }
}