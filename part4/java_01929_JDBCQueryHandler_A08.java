import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01929_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbname",
                    "username",
                    "password");

            // Create a new statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM table_name");

            // Handle result set
            while (rs.next()) {
                // TODO: Process the result set data
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