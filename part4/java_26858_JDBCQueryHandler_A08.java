import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26858_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;

        try {
            // Load Oracle driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connect to Oracle database
            conn = DriverManager.getConnection(url, username, password);

            // Execute a query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");

            // Handle the result set
            while (rs.next()) {
                // You can use the ResultSet here to handle the data
                String column1 = rs.getString("column1");
                int column2 = rs.getInt("column2");
                // ...
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}